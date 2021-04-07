job('NodeJSexampleWithDockerBuild') {
    scm {
        git('https://github.com/rakeshdyx/node-app.git')
    }
    triggers {
        scm('* * * * *')
    }
    wrappers {
        nodejs('nodejslatest')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('rakeshdyx/nodejs-demo')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}