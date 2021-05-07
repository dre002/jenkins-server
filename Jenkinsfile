pipeline{
    agent any
    stages {
        stage("Package") {
            agent {
                docker {
<<<<<<< HEAD
                    image 'maven:3.5.4'
=======
                    image 'maven 3.5.4'
>>>>>>> 509c9fcaf54f128462614fb90ba66723ed832b28
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }
        stage("Test") {
            agent {
                docker{
<<<<<<< HEAD
                    image 'maven:3.5.4'
=======
                    image 'maven 3.5.4'
>>>>>>> 509c9fcaf54f128462614fb90ba66723ed832b28
                }
            }
            steps {
                sh 'mvn tests'
            }
        }
        stage("Build") {
            agent any
            steps {
                sh 'pwd'
                sh 'docker build . --tag server'
            }
        }
        stage("Deployment") {
            agent any
            steps {
                sh 'docker run -d -p 5000:5000 server:latest'
            }
        }
    }
}