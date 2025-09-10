pipeline {
    agent any
    tools {
        maven "maven3.9"
    }

    stages {
        stage ("built jar") {
            steps {
                script {
                    echo " buiding the application ..."
                    sh "mvn clean package"
                }
            }
        }
    stage ("built docker iamge") {
            steps {
                script {
                    echo " buiding the docker image ..."
                    withCredentials([usernamePassword(credentialsId: 'docker_registry', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t eswar1241/my-repo:jma-1.0 ."
                        sh "echo $PASS |docker login -u $USER --password-stdin"
                        sh "docker push eswar1241/my-repo:jwa-1.2"
                    }
                }
            }
        }
        stage ("deploy") {
            steps {
                echo " Deploying the application ..."
            }
        }
    }
}
