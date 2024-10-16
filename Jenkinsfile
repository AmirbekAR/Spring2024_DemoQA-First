pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'UI', description: 'UI')
    }

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
                // Используем параметр TEST_GROUP для запуска тестов
                sh "mvn test -Dgroups=\"${params.TEST_GROUP}\""
            }
        }

        stage('Allure Report') {
            steps {
                // Генерация отчета Allure
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
