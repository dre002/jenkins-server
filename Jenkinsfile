pipeline{
    agent any
    stages {
        stage("Package") {
            agent {docker 'maven:3.5.4-adoptopenjdk-11'}
            steps {
                sh 'mvn install'
            }
        }
        stage("Test") {
            agent {docker 'maven:3.5.4-adoptopenjdk-11'}
            steps {
                sh 'mvn tests'
            }
        }
        stage("Build") {
            agent {dockerfile true}
            steps {
                sh 'docker build . --tag server'
            }
        }
        stage("Deployment") {
            agent {dockerfile true}
            steps {
                sh 'docker run -d -p 5000:5000 server:latest'
            }
        }
    }
}