pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t='247sri/docker_selenium' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: '12268700sri', usernameVariable: '247sri')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push 247sri/docker_selenium:latest"
			    }
            }
        }
    }
}