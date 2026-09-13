pipeline {

    agent {
        label 'linux-agent'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Cloning source code from GitHub'
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                sh '''
                    echo "Node: $NODE_NAME"
                    echo "Workspace: $WORKSPACE"
                    java -version
                    mvn -version
                '''
            }
        }

        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Verify WAR') {
            steps {
                sh '''
                    echo "Generated WAR files:"
                    find target -name "*.war" -type f
                '''
            }
        }
    }

    post {
        success {
            echo 'Maven CI Build completed successfully!'
        }

        failure {
            echo 'Maven CI Build failed!'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
