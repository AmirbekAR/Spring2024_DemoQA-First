pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['Pipeline', 'Smoke', 'Regression'], description: 'Select the type of tests to run')
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
                    def profile

                    // Определяем профиль в зависимости от выбора
                    switch (params.TEST_TYPE) {
                        case 'Pipeline':
                            profile = 'Pipeline'
                            break
                        case 'Smoke':
                            profile = 'Smoke'
                            break
                        case 'Regression':
                            profile = 'Regression'
                            break
                        default:
                            error("Unknown test type: ${params.TEST_TYPE}")
                    }

                    // Запуск тестов с выбранным профилем
                    echo "Executing: mvn test -P${profile}"
                    sh "mvn test -P${profile}"
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    sh "allure serve target/allure-results"
                }
            }
        }
    }
}
