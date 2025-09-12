def gv

pipeline {
    agent any
    tools {
        maven "maven3.9"
    }

    stages {
        stage ("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage ("build jar") {
            steps {
                script {
                    gv.buildjar ()
                }
            }
        }
        stage ("build docker image") {
            steps {
                script {
                    gv.buildDockerImage()
                }

            }
        }
        stage ("Deploying Appliction") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}