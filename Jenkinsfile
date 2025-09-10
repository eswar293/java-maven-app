pipeline {
    agent any
    tools {
        maven "maven3.9"
    }
    environment {
        IMAGE_NAME = "eswar1241/my-repo"
        IMAGE_TAG  = "jwa-1.2"
    }

    stages {
        stage ("built jar") {
            steps {
                script {
                    echo " buiding the application ..."
                    sh "mvn package"
                }
            }
        }
    stage ("built docker iamge") {
            steps {
                script {
                    echo " buiding the docker image ..."
                    withCredentials([usernamePassword(credentialsId: 'docker_registry', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t ${IAMGE_NAME}/${IMAGE_TAG} ."
                        sh "echo $PASS |docker login -u $USER --password-stdin"
                        sh "docker push ${IAMGE_NAME}/${IMAGE_TAG}"
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
