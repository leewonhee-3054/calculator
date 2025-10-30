pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Test') {
      steps {
        sh 'chmod +x gradlew || true'
        sh './gradlew --version'
        sh './gradlew clean test'
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
        }
      }
    }

    stage('Build (Jar)') {
      steps {
        sh './gradlew bootJar'
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
      echo '✅ Build OK & Tests Passed!'
    }
    failure {
      echo '❌ Build or Tests Failed.'
    }
  }
}
