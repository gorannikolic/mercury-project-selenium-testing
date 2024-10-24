pipeline {
    agent any

    stages {
        stage('Maven Clean') {
            steps {
                powershell 'mvn clean'
            }
        }
        stage('Maven Test') {
            steps {
                powershell 'mvn test'
            }
        }
    }
}
