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
                    sh "mvn package"
                }
            }
        }
        stage ("built docker iamge") {
            steps {
                script {
                    echo " buiding the docker image ..."
                    withCredentials([usernamePassword(credentialsId: 'Docker_Repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t eswar1241/my-repo:jma-1.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push eswar1241/my-repo:jma-1.0'
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