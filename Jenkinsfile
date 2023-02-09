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
					    		sh 'docker info'
					    		sh 'docker compose version'
					    		sh '/usr/bin/docker compose up -d'
				        }
					}
				}
				stage('Tests Execution'){
					steps{
					     script{
							sh 'mvn clean test'
					     }
						 }
				}
				stage('Selenium-Grid Tear Down'){
					steps{
					        script{
								sh '/usr/bin/docker compose down'
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