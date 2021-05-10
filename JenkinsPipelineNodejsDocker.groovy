node {
    def commit_id
    stage('Preparation') {
        checkout scm
        sh "git rev-parse --short HEAD > .git/commit_id"
        commit_id = readFile('.git/commit_id').trim()
    }
    stage('test') {
        nodejs(nodeJSInstallationName: 'nodejs') {
            sh "npm install --only=dev"
            sh "npm test"
        } 
    }
    stage('Docker build/push') {
        docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
            def app = docker.build('rakeshdyx/nodejs-demo', '.').push()
        }
    }

}