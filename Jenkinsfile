pipeline {
    agent any
    environment{
    DOCKERHUB_CREDENTIALS = credentials('nizarbouhsaine-dockerhub')
    }
    tools{
        maven 'Maven'
    }
    stages {
        stage('Build Maven') {
            steps {
               checkout scmGit(branches: [[name: '*/hamdani']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Gestion-Stock-Jira/backend.git']])
               sh './mvnw clean install'
            }
        }
        stage('Test')
        {
            steps{
                sh './mvnw test'
            }
        }
        stage('Build Docker Image')
        {
        steps{
        sh 'mvn compile jib:dockerBuild'
        sh 'docker build -t nizarbouhsaine/devops-gestion:latest .'
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        sh 'docker push nizarbouhsaine/devops-gestion:latest'
        }
        }

    }
    post{
    always{
    sh 'docker logout'
    }}
}
