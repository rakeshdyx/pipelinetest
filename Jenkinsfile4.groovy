pipeline {
    agent any
    environment {
        CC = """${sh(
            returnStdout: true,
            script: 'echo "clang"'
        )}"""
        EXIT_STATUS = """${sh(
                returnStatus: true,
                script = 'exit 1'
        )}"""
    }
    stages {
        stage('Example..') {
            environment {
                DEBUG_FLAGS = '-g'
            }
            steps {
                sh "printenv"
            }
        }
    }
}