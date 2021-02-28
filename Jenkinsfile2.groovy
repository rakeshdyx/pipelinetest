pipeline {
    agent any
    stages {
        stage('Example...') {
            step {
                echo "Running ${env.BUILD_ID} on Jenkin URL-${env.JENKINS_URL}"
            }
        }
    }
}