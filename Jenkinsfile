pipeline{
    agent any
    stages {
        stage("Package") {
            agent {
                docker {
                    image 'maven:3.5.4'
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Test") {
            agent {
                docker{
                    image 'maven:3.5.4'
                }
            }
            steps {
                sh 'mvn test'
            }
        }
        stage("Build") {
            agent any
            steps {
                sh 'pwd'
                sh 'docker kill $(docker ps -q)'
                sh 'docker rm $(docker ps -a -q)'
                sh 'docker build . --tag server'
            }
        }
        stage("Deployment") {
            agent any
            steps {
                sh 'docker run -d -p 5001:5001 server:latest'
            }
        }
    }
}