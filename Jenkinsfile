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
                        sh "mvn test -PPipeline"
                    } else if (params.TEST_TYPE == 'Smoke') {
                        sh "mvn test -PSmoke"
                    } else if (params.TEST_TYPE == 'Regression') {
                        sh "mvn test -PRegression"
                    }
                }
            }
        }
    }
}
