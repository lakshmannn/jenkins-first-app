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

        stage('Build Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image (Jib)') {
            steps {
                sh "mvn compile jib:dockerBuild -Dimage=${IMAGE_NAME}"
            }
        }

        stage('Run Docker Image (Optional)') {
            steps {
                sh "docker run -d -p 8089:8089 ${IMAGE_NAME}"
            }
        }
    }

    post {
        failure {
            echo 'Pipeline failed!'
        }
    }
}
