node {
  def registryProjet="/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/"
  stage('clone project'){
    git 'https://github.com/saadou11/cicd-project'
  }
  stage('Clean-Compile'){
  sh 'mvn clean package'
  }
  stage('Ansible psql Image'){
          ansiblePlaybook (
          colorized: true,
            playbook: '${registryProjet}psqlImage.yml'
      )
  }
    stage('Ansible java Image'){
          ansiblePlaybook(
          colorized: true,
          playbook: '${registryProjet}javaImage.yml'
      )
  }
    stage('Ansible docker volume'){
          ansiblePlaybook(
          colorized: true,
          playbook: '${registryProjet}createVolume.yml'
      )
  }
    stage('Ansible docker network'){
          ansiblePlaybook(
          colorized: true,
          playbook: '${registryProjet}createNetwork.yml'
      )
  }
    stage('Ansible psql Container'){
          ansiblePlaybook(
          colorized: true,
          playbook: '${registryProjet}createContainer.yml'
      )
  }
      stage('Ansible java Container'){
          ansiblePlaybook(
          colorized: true,
          playbook: '${registryProjet}createJavaContainer.yml'
      )
  }
}
