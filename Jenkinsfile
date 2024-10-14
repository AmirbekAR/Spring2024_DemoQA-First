pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AmirbekAR/Spring2024_DemoQA.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}

