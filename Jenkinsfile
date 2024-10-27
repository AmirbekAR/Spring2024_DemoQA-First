pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['Smoke', 'Regression', 'Pipeline'], description: 'Select the type of tests to run')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
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
                    echo "Running tests with profile: ${params.TEST_TYPE}"
                    if (params.TEST_TYPE == 'Pipeline') {
                        echo "Executing: mvn test -PPipeline"
                        sh "mvn test -PPipeline"
                    } else if (params.TEST_TYPE == 'Smoke') {
                        echo "Executing: mvn test -PSmoke"
                        sh "mvn test -PSmoke"
                    } else if (params.TEST_TYPE == 'Regression') {
                        echo "Executing: mvn test -PRegression"
                        sh "mvn test -PRegression"
                    }
                }
            }
        }
        stage('Allure Report') {
            steps {
                script {
                    // Убедитесь, что путь к вашим результатам Allure корректный
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
    post {
        always {
            // Генерация отчета Allure
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
