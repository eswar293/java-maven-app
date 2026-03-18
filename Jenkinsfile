#! /user/bin/env groovy

@Library('Jenkins-shared-library')
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
                    buildjar ()
                }
            }
        }
        stage ("build docker image") {
            steps {
                script {
                    buildImage()
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