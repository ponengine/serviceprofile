pipeline {
    agent any
    environment{
        registry = "ponengine/service-profile"
        img = "$registry"+":${env.BUILD_ID}"
        registryCredential = 'docker-hub-login'
    }
    stages {
        stage('pull project') {
            steps {
                 git branch: 'main', credentialsId: 'key_github', url: 'https://github.com/ponengine/serviceprofile.git'
            }
        }
        stage('install'){
            steps{
                sh 'mvn package'
            }
        }
        stage('build image'){
            steps{
                echo "Building our image"
                script{
                    dockerImg = docker.build("${img}")
                }
                //sh 'docker build  -t serviceprofile .'
                //sh 'docker run --rm -d -p 8082:8082 serviceprofile'
            }
        }
        stage('Release'){
            steps{
                script{
                    withDockerRegistry(credentialsId: 'docker-hub-login') {
                        dockerImg.push();
                        dockerImg.push('latest');
                    }
                }
            }
        }
    }
}