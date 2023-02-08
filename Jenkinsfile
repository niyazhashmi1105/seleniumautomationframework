pipeline{
    agent any
        tools{
              maven 'Maven'
            }
        stages{
                stage('git check out'){
                    steps{
                        checkout scmGit(branches: [[name: '*/main']], extensions: [], 
                        userRemoteConfigs: [[url: 'https://github.com/niyazhashmi1105/seleniumautomationframework']])
                        
                    }
                }
				stage('selenium-grid set up'){
					steps{
					    script{
					        '''cd D:/eclipse-project/SeleniumAutomationFramework '''
							bat 'docker-compose up --scale chrome=3 -d'
				        }
					}
				}
				stage('tests execution'){
					steps{
					     script{
							bat 'mvn clean test'
					     }
						 }
				}
				stage('selenium-grid tear down'){
					steps{
					        script{
							bat 'docker-compose down'
					        }
						}
				}
			}
		 post{
            always{
                  
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'extent-test-output', 
                    reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        
    }
}			