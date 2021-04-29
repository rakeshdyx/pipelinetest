node {
    def mvnHome

    stage('Preparation') {
        git 'https://github.com/rakeshdyx/node-app.git'
        //Get the maven tool must be configured
        //**Note: This 'M3' Maven tool must be configured in global config
        mvnHome = tool 'maven3.0'
    }
    stage('Build') {
        // Run the maven build
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
        } else {
            bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
    }

    stage('Result') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.jar'
    }
}