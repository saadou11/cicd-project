package utils;

import entities.Client;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.postgresql.util.PSQLException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JdbcUtils {

    private static Logger logger = Logger.getLogger(JdbcUtils.class);

    private static final String url = "jdbc:postgresql://";
    private static final String user = "testcicd";

    static public Connection connect(String dbName,String port) {
        // To singleton, use the static variable already created
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url + port + "/" + dbName, user, "helloWorld");
            logger.info("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * this function allow us to insert fake data into our database
     *
     * @param conn the conn parameter of our database
     * @param table the table in our database and also ther name of the
     * @param data
     */
    static public void insertData(Connection conn, Class<? extends Client> table, JSONObject data) {
        Statement stmt = null;

        try {
            logger.info("inserting Record...");
            stmt = conn.createStatement();
            StringBuilder str = new StringBuilder();

            int i = 0;
            str.append("INSERT INTO " + table.getSimpleName() + " (");
            str.append(Arrays.stream(table.getDeclaredFields())
                    .map(field -> field.getName())
                    .collect(Collectors.joining(", ")));

            str.append(')');
            
            str.append(" VALUES(");
            str.append(Arrays.stream(table.getDeclaredFields())
                    .map(field -> data.get(field.getName()).toString())
                    .map(field -> field.replace("'", "_"))
                    .map(field -> "'" + field + "'")
                    .collect(Collectors.joining(", ")));

            str.append(");");

            stmt.executeUpdate(str.toString());
            logger.info("Records inserted successfully...");
        } catch (PSQLException se) {
            System.out.println(se.getMessage());
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        } // end try
    }
}
