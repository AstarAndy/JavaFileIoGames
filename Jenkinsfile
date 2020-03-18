pipeline {
  agent any

    stages {

		stage('Fetch project source from git')
			steps {
				echo 'Clone source code repo'
				sh 'git clone https://github.com/AstarAndy/JavaFileIoGames.git'
			}
			

        stage('Build JAR') {
            steps {
                echo 'Building now'
                echo '  switching to root project folder'
                sh 'cd ......l hahhahah'
                sh 'mvn --version'
                sh 'mvn package'
                echo ' **** The build output folder now contains the following *** '
                sh 'ls -al ./target/'
            }
        }

        stage('Build Docker Container') {
            steps {
                echo 'Building Docker Container now'
                sh './buildDockerImage.sh'
                sh 'ls -al'
            }
        }

        stage('Deploying Docker Container') {
        steps {
          echo 'Deploying....'
        }
      }

    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
            junit 'build/test-results/test/**/*.xml'
        }
    }


}