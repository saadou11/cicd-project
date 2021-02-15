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
          playbook: 'psqlImage.yml'
      )
  }
    stage('Ansible java Image'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: 'javaImage.yml'
      )
  }
    stage('Ansible docker volume'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: 'createVolume.yml'
      )
  }
    stage('Ansible docker network'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: 'createNetwork.yml'
      )
    sh 'ansible-playbook myAnsibleRole/tasks/createNetwork.yml'
  }
    stage('Ansible psql Container'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: 'createContainer.yml'
      )
  }
      stage('Ansible java Container'){
          ansiblePlaybook(
          colorized: true,
          become: true,
          playbook: 'createJavaContainer.yml'
      )
  }
}
