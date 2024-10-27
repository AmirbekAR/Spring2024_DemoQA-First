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
                // Запуск только пайплан тестов
                sh "mvn test -PPipeline"
            }
        }

        stage('Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}
