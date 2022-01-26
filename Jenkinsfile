pipeline {
    agent any
  //triggers {pollSCM('* * * * *')}
  stages {
    stage('Checkout') {
      steps {
        // Get some code from a GitHub repository
        git branch: "main", url: 'https://github.com/revature-spring-savings/Spring-Savings-Backend.git'
      }
    }
        stage('Build') {
      steps {
        sh 'chmod a+x mvnw'
        sh './mvnw clean package -DskipTests=true'
      }

          post {
        always {
          archiveArtifacts 'target/*.jar'
        }
          }
        }
        stage('DockerBuild') {
      steps {
        sh 'docker build -t revature-spring-savings/rest-api:latest .'
      }
        }
         stage('DockerRun') {
      steps {
        sh 'docker run -p 9091:9091 revature-spring-savings/rest-api'
      }
        }
  }
}
