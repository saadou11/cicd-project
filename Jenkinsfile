node {
  stage('SCM checkout'){
    git 'https://github.com/saadou11/cicd-project'
  }
  stage('Clean-Compile'){
  sh 'mvn clean package'
  }
}
