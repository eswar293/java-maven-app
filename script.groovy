def buildapp() {
    echo "Building Application"
}

def testapp() {
    
    echo "Testing the Application"
    
}

def deployapp() {
    echo "Deploying the Application"
    echo "deploying version ${params.VERSION}"
}

return this