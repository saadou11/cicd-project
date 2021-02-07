package application;

import entities.Client;
import jdk.nashorn.api.scripting.JSObject;
import utils.FakerUtils;
import org.json.JSONObject;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws SQLException {


        Connection cnx = JdbcUtils.connect("testdatabase",args[0]);

        for(int i = 0; i <= 1000;  i++){

            JSONObject fakeData = FakerUtils.fakeJsonData(FakerUtils.getFaker());
            JdbcUtils.insertData(cnx, Client.class,fakeData);

        }

        cnx.close();
    }
}
