pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'UI')
        choice(name: 'TEST_TYPE', choices: ['Pipeline'], description: 'Select the type of tests to run')
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
                script {
                    // Запуск тестов в зависимости от выбора
                    if (params.TEST_TYPE == 'Smoke') {
                        sh "mvn test -PSmoke"
                    } else if (params.TEST_TYPE == 'Regression') {
                        sh "mvn test -PRegression"
                    } else if (params.TEST_TYPE == 'Pipeline') {
                        sh "mvn test -PPipeline"
                    }
                }
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
