pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                echo 'Building application - Webhook Test'
                sh 'pwd'
                sh 'ls -la'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing application'
                sh 'java -version'
            }
        }

        stage('Code Quality') {
            steps {
                echo 'Checking code quality'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application'
            }
        }
    }

    post {

        success {
            echo 'Pipeline completed successfully'
        }

        failure {
            echo 'Pipeline failed'
        }

        always {
            echo 'Pipeline execution completed'
        }
    }
}
