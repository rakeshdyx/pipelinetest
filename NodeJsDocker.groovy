job('NodeJSexampleWithDockerBuild') {
    scm {
        git('https://github.com/rakeshdyx/node-app.git') { node->
                node / gitConfigName('rakeshdyx')
                node / gitConfigEmail('rakeshdyx@gmail.com')        
                }
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
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}