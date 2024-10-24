pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'UI') // Установлен параметр по умолчанию для группы
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AmirbekAR/Spring2024_DemoQA.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn install' // Установка зависимостей
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn test -Dgroups=${params.TEST_GROUP}" // Запуск тестов только для указанной группы
            }
        }

        stage('Allure Report') {
            steps {
                sh 'mvn allure:report' // Генерация отчета Allure
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Сбор результатов тестов
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}
