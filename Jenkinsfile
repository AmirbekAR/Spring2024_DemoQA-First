pipeline {
    agent any

    parameters {
        choice(name: 'TEST_TYPE', choices: ['Pipeline', 'Smoke', 'Regression'], description: 'Select the type of tests to run')
    }

    environment {
        // Устанавливаем переменную окружения для выбора профиля
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

                    // Определяем путь к нужному testng.xml в зависимости от типа тестов
                    def testngFile = ""

                    if (params.TEST_TYPE == 'Pipeline') {
                        testngFile = 'src/test/resources/test_suites/pipeline_suite.xml'
                    } else if (params.TEST_TYPE == 'Smoke') {
                        testngFile = 'src/test/resources/test_suites/smoke_suite.xml'
                    } else if (params.TEST_TYPE == 'Regression') {
                        testngFile = 'src/test/resources/test_suites/regression_suite.xml'
                    } else {
                        error("Unknown test type: ${params.TEST_TYPE}")
                    }

                    echo "Running TestNG with: ${testngFile}"

                    // Запуск тестов через Maven
                    sh "mvn clean test -Dtestng.suiteXmlFiles=${testngFile} -P${params.TEST_TYPE} -Dmaven.repo.local=/var/jenkins_home/.m2/repository"
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    // Генерация Allure отчета с помощью Maven
                    sh "mvn allure:report"
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    echo "Displaying Allure Report"
                    // Отображение отчета Allure в Jenkins
                    allure([
                        includeProperties: false,
                        results: [[path: 'target/allure-results']],  // Путь к результатам тестов
                        report: 'target/allure-report'  // Путь к отчету Allure
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
