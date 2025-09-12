def buildjar() {
    echo "Building the Application ..."
    sh "mvn package"
}

def buildDockerImage() {
echo "Building the docker iamge ..."
    withCredentials([usernamePassword(credentialsId: 'Docker_Repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t eswar1241/my-repo:jma-1.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push eswar1241/my-repo:jma-1.0'
    }
}

def deployApp() {
    echo "Deploying the application ..."
}

return this
