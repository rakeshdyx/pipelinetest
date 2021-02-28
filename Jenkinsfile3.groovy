pipeline {
    agent any
    stages {
        environment {
            CC = 'clang'
        }
        stage {
            environment {
                BUILD_FLAG = '-g'
            }
            steps {
                sh 'printenv'
            }
        }
    }
}