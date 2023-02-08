pipeline{
    agent any
        tools{
              maven 'Maven'
            }
        stages{
                stage('Git Check Out'){
                    steps{
                        checkout scmGit(branches: [[name: '*/main']], extensions: [], 
                        userRemoteConfigs: [[url: 'https://github.com/niyazhashmi1105/seleniumautomationframework']])
                        
                    }
                }
				stage('Selenium-Grid Set Up'){
					steps{
					    script{
					        '''cd /usr/SeleniumAutomationFramework '''
								bat 'docker-compose up --scale chrome=3 -d'
				        }
					}
				}
				stage('Tests Execution'){
					steps{
					     script{
							bat 'mvn clean test'
					     }
						 }
				}
				stage('Selenium-Grid Tear Down'){
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