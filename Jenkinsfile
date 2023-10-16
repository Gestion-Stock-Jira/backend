pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage('Build Maven') {
            steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Gestion-Stock-Jira/backend.git']])
               sh './mvnw clean install'
            }
        }
        stage('Test')
        {
            steps{
                sh './mvnw test'
            }
        }

    }
}
