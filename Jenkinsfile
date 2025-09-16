pipeline {
    agent any
    tools {
        maven "maven3.9"
    }

    stages {
        stage("incrementing the app version") {
            steps {
                script {
                    echo "Incrementing the app version"
                    sh "mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    def version = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
                    echo "Version is ${version}"
                }
            }
        }

        stage("Build app") {
            steps {
                script {
                    echo "Building the app ..."
                    sh 'mvn clean package'
                }
            }
        }

        stage("Building Docker Image"){
            steps{
                script{
                    echo "Building the Docker image and pushing it to docker repo"
                    withCredentials([UsernamePassword(credentialsId: 'Docker_login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t eswar1241/my-repo:$VERSION"
                        sh 'echo $PASS |docker login -u $USER --password-stdin'
                        sh "docker push eswar1241/my-repo:$VERSION"
                    }
                }
            }
        }

        stage("Deploying"){
            steps{
                script{
                    echo "Deploying the application"
                }
            }
        }
    }
}