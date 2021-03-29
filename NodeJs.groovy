job('NoeJSExample') {
    scm {
        git('https://github.com/rakeshdyx/docker-demo.git') { node -> 
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
        shell('npm install')
    }

}