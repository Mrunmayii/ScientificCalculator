pipeline {
    agent any
    environment {
            DOCKER_IMAGE_NAME = 'scientific_calculator'
            DOCKER_TAG = 'mrunmayi12/scientific_calculator:latest'
            GITHUB_REPO_URL = 'https://github.com/Mrunmayii/ScientificCalculator.git'
            DOCKER_CREDENTIALS = 'docker-cred'
     }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker --version'
//                     sh "docker build -t ${DOCKER_IMAGE_NAME} ."
                    sh "docker build --cache-from=${DOCKER_TAG} -t ${DOCKER_IMAGE_NAME} ."

                }
            }
        }
        stage('Docker Hub Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDENTIALS, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '''
                        echo "Logging into Docker Hub..."
                        echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin || echo "Docker login failed!"
                    '''
                }
            }
        }
        stage('Push Docker Images') {
            steps {
                script {
                    sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_TAG}"
                    sh "docker push ${DOCKER_TAG}"
                }
            }
        }
        stage('Clean Up Docker Images') {
            steps {
                sh "docker rmi ${DOCKER_TAG} || true"
                sh "docker rmi ${DOCKER_IMAGE_NAME} || true"
            }
        }
        stage('Deploy using Ansible') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'local-cred', usernameVariable: 'ANSIBLE_USER', passwordVariable: 'ANSIBLE_PASS')]) {
                    sh '''
                        export ANSIBLE_BECOME_PASS="$ANSIBLE_PASS"
                        ansible-playbook -i inventory.ini deploy.yml --extra-vars "ansible_user=$ANSIBLE_USER"
                    '''
                }
//                    sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }

    }
}
