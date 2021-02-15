node {
  stage('SCM checkout'){
    git 'https://github.com/saadou11/cicd-project'
  }
  stage('Clean-Compile'){
  sh 'mvn clean package'
  }
  stage('Ansible psql Image'){
          ansiblePlaybook (
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/psqlImage.yml'
      )
  }
    stage('Ansible java Image'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/javaImage.yml'
      )
  }
    stage('Ansible docker volume'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/createVolume.yml'
      )
  }
    stage('Ansible docker network'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/createNetwork.yml'
      )
  }
    stage('Ansible psql Container'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/createContainer.yml'
      )
  }
      stage('Ansible java Container'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: '/home/saadou/ci-cd_Workspace/testPsqlDocker/tasks/createJavaContainer.yml'
      )
  }
}
