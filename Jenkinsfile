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
                // Убедитесь, что зависимости (включая TestNG) установлены с помощью Maven
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    echo "Running tests with profile: ${params.TEST_TYPE}"

                    // Устанавливаем путь к нужному testng.xml в зависимости от выбора
                    def testngFile = ""

                    // Устанавливаем путь к нужному testng.xml в зависимости от выбора
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

                    // Запускаем тесты через Maven с нужным профилем и файлом suite
                    sh "mvn clean test -Dtestng.suiteXmlFiles=${testngFile} -P${params.TEST_TYPE}"
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    // Генерируем отчет Allure с помощью Maven
                    sh "mvn allure:report"
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    // Сохраняем Allure отчет в Jenkins
                    allure([
                        includeProperties: false,
                        results: [[path: 'target/allure-results']],  // Путь к результатам Allure
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
