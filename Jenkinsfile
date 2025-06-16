pipeline {
    agent any

    environment {
        IMAGE_NAME = 'lakshmannn/order-management-system'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/lakshmannn/jenkins-first-app.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
             steps {
                bat 'mvn test'
             }
        }

        stage('Build Docker Image (Jib)') {
            steps {
                bat "mvn compile jib:dockerBuild -Dimage=${IMAGE_NAME}"
            }
        }

        stage('Run Docker Image (Optional)') {
            steps {
                bat "docker run -d -p 8089:8089 ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline success..'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
