pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/Gestion-Stock-Jira/backend.git'
                sh './mvnw clean compile'
            }
        }
    }
}
