node {
  stage('SCM checkout'){
    git 'https://github.com/saadou11/cicd-project'
  }
  stage('Clean-Compile'){
  sh 'mvn clean package'
  }
  stage('Ansible psql Image'){
    sh 'ansible-playbook myAnsibleRole/tasks/psqlImage.yml'
  }
    stage('Ansible java Image'){
    sh 'ansible-playbook myAnsibleRole/tasks/javaImage.yml'
  }
    stage('Ansible docker volume'){
    sh 'ansible-playbook myAnsibleRole/tasks/createVolume.yml'
  }
    stage('Ansible docker network'){
    sh 'ansible-playbook myAnsibleRole/tasks/createNetwork.yml'
  }
    stage('Ansible psql and java Container'){
    sh 'ansible-playbook myAnsibleRole/tasks/createContainer.yml && ansible-playbook myAnsibleRole/tasks/createJavaContainer.yml'
  }
}
