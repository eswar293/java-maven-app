def buildapp() {
    echo "Building Application"
}

def testapp() {
    
    when {
        expression {
          params.executeTests
        }
      }
    echo "Testing the Application"
    
}

def deployapp() {
    echo "Deploying the Application"
    echo "deploying version ${params.VERSION}"
}

return this