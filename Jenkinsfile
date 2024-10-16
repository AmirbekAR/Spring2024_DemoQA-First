pipeline {
    agent any

    parameters {
        string(name: 'TEST_GROUP', defaultValue: 'UI', description: 'TC1')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AmirbekAR/Spring2024_DemoQA.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    try {
                        sh 'mvn install'
                    } catch (Exception e) {
                        error "Failed to install dependencies: ${e.message}"
                    }
                }
            }
        }

      stage('Run Tests') {
          steps {
              script {
                  try {
                      sh "mvn test -P${params.TEST_GROUP}"
                  } catch (Exception e) {
                      error "Test execution failed: ${e.message}"
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
