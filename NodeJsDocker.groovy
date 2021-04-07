job('NodeJSexampleWithDockerBuild') {
    scm {
        git(''https://github.com/rakeshdyx/node-app.git'')
    }
    triggers {
        smc('* * * * *')
    }
    wrappers {
        nodejs('nodejslatest')
    }
    steps {
        dockerBuildAndPulish {
            repositoryName('rakeshdyx/nodejs-demo')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredendtials('docker-hub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}