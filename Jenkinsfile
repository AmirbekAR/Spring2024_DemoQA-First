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
                // Установка зависимостей с явным указанием профиля (если необходимо)
                sh 'mvn clean install'  // Или с профилем: mvn clean install -P<profile>
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Логируем информацию о выбранном тесте
                    echo "Running tests with profile: ${params.TEST_TYPE}"

                    // Устанавливаем путь к нужному testng.xml в зависимости от выбора
                    def testngFile = ""

                    // Используем if-else для выбора файла
                    if (params.TEST_TYPE == 'Pipeline') {
                        testngFile = 'src/test/resources/test_suites/pipeline_suite.xml'
                    } else if (params.TEST_TYPE == 'Smoke') {
                        testngFile = 'src/test/resources/test_suites/smoke_suite.xml'
                    } else if (params.TEST_TYPE == 'Regression') {
                        testngFile = 'src/test/resources/test_suites/regression_suite.xml'
                    } else {
                        error("Unknown test type: ${params.TEST_TYPE}")
                    }

                    // Логируем какой файл теста будет использоваться
                    echo "Running TestNG with: ${testngFile}"

                    // Запускаем тесты через TestNG с выбранным testng.xml
                    def classpath = "target/classes:" + sh(script: "echo target/*.jar | tr ' ' ':'", returnStdout: true).trim()
                    sh "java -cp '${classpath}' org.testng.TestNG ${testngFile}"
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    // Генерация отчета Allure
                    sh "allure serve target/allure-results"
                }
            }
        }
    }
}
