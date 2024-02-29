pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    bat 'mvn -e clean test -Dmaven.test.failure.ignore=true'
                }
            }
        }
        stage('Publis Allure Report') {
            steps {
                script {
                    bat 'allure generate allure-results -o allure-report'

                    archiveArtifacts 'allure-report/**'
                }
            }
        }
    }

    post {
        always {
            allure(
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure/results']
            )
        }
    }
}