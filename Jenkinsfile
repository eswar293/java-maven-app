pipeline {
  agent any
  parameters {
    choice (name: "VERSION", choices: ['1.0.0', '1.2.0', '1.3.0'], description: "")
    booleanparam(name : 'executeTests', defaultvalue: true, descripton:"")
  }

  stages {

    stage ("build") {
      
      steps {
        echo "buiding application"
      }
    }

    stage ("test") {
      when {
        expression {
          params.executeTests
        }
      }
      steps {
        echo "testing application"
      }
    }

    stage ("deploy") {
      
      steps {
        echo "deploying application"
        echo "deploying version ${params.VERSION}"
      }
    }
  }
}