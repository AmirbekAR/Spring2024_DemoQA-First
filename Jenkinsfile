pipeline {
    agent any

    parameters {
        choice(name: 'TEST_TYPE', choices: ['Pipeline', 'Smoke', 'Regression'], description: 'Select the type of tests to run')
    }

    environment {
        MAVEN_OPTS = "-Duser.home=/var/jenkins_home"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    echo "Installing dependencies..."
                    // Устанавливаем зависимости через Maven
                    sh 'mvn clean install -Dmaven.repo.local=/var/jenkins_home/.m2/repository'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    echo "Running tests with profile: ${params.TEST_TYPE}"

                    // Выводим значение параметра для диагностики
                    echo "Selected TEST_TYPE: ${params.TEST_TYPE}"

                    // Запуск тестов через Maven с передачей параметра профиля
                    sh """
                        mvn clean test -P${params.TEST_TYPE} -Dmaven.repo.local=/var/jenkins_home/.m2/repository -X
                    """
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    sh "mvn allure:report"
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    echo "Displaying Allure Report"
                    allure([
                        includeProperties: false,
                        results: [[path: 'target/allure-results']],
                        report: 'target/allure-report'
                    ])
                }
            }
        }
    }

    post {
        always {
            cleanWs()  // Очистка рабочего пространства после выполнения
        }
    }
}
