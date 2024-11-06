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

                    // Получаем classpath
                    def classpath = "target/classes:" + sh(script: "echo target/*.jar | tr ' ' ':'", returnStdout: true).trim()
                    echo "Classpath: ${classpath}"

                    // Запускаем TestNG с нужным testng.xml
                    sh "java -cp '${classpath}' org.testng.TestNG ${testngFile}"
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
