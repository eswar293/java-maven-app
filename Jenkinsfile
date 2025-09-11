pipeline {
    agent any
    tools {
        maven "maven3.9"
    }

    stages {
        stage ("build jar") {
            steps {
                script {
                    echo "Building the jar package ..."
                    sh "mvn package"

                }
            }
        }
        stage ("build docker image") {
            steps {
                script {
                    echo "Building the docker iamge ..."
                    withCredentials([usernamePassword(credentialsId: 'Docker_Repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t eswar1241/my-repo:jma-1.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push eswar1241/my-repo:jma-1.0'
                    }

                }
            }
        }
        stage ("Deploying Appliction") {
            steps {
                script {
                    echo "Deploying the application ..."
                }
            }
        }
    }
}