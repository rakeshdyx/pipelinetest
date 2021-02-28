pipeline {
    agent any
    environment {
        CC = """${sh(
            returnStdout: true,
            script: 'echo "clang"'
        ) }"""
    }
    stages {
        stage('Example..') {
            environment {
            DEBUG_FLAGS = """${sh(
                returnStatus: true,
                script = 'exit 1'
            )}"""
            }
            steps {
                sh "printenv"
            }
        }
    }
}