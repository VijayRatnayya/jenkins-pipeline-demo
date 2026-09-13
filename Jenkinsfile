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

        stage('Deploy to Tomcat') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'tomcat-credentials',
                    usernameVariable: 'TOMCAT_USER',
                    passwordVariable: 'TOMCAT_PASS'
                )]) {
                    sh '''
                        echo "Deploying WAR to Tomcat..."

                        curl --fail --silent --show-error \
                          --user "$TOMCAT_USER:$TOMCAT_PASS" \
                          --upload-file target/jenkins-webapp.war \
                          "http://localhost:8081/manager/text/deploy?path=/jenkins-webapp&update=true"

                        echo "WAR deployment completed successfully!"
                    '''
                }
            }
        }

        stage('Verify Deployment') {
            steps {
                sh '''
                    echo "Verifying deployed application..."

                    curl --fail --silent \
                      http://localhost:8081/jenkins-webapp/hello

                    echo
                    echo "Application verification completed successfully!"
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
