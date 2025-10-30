pipeline {
  agent any

  tools {
    jdk 'JDK17'   // Jenkins > Global Tool Configuration 에서 이름 'JDK17' 로 등록
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  triggers {
    // GitHub Webhook을 쓰면 여기 생략 가능. (SCM 폴링은 비권장)
    // pollSCM('* * * * *')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        // 또는:
        // git branch: 'main', url: 'https://github.com/<user>/calculator.git', credentialsId: 'GIT_PAT_CRED_ID'
      }
    }

    stage('Test') {
      steps {
        sh './gradlew --version'
        sh './gradlew clean test'
      }
      post {
        always {
          // JUnit 결과 업로드 (Jenkins Test Result)
          junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
        }
      }
    }

    stage('Build (Jar)') {
      steps {
        sh './gradlew bootJar'   // 또는 ./gradlew build (테스트 포함)
      }
      post {
        success {
          archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
        }
      }
    }

    // (옵션) Docker 이미지 빌드/푸시 추가 가능
    // stage('Docker Build') { ... }
  }

  post {
    success { echo '✅ Build OK & Tests Passed!' }
    failure { echo '❌ Build or Tests Failed.' }
  }
}
