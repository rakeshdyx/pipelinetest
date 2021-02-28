pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               echo 'Building'
               sh "${env.BUILD_ID}"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}