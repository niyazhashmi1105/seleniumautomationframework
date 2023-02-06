pipeline{
    
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        
        stage('build'){
            steps{
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], 
                    userRemoteConfigs: [[credentialsId: 'niyazhashmi1105', 
                    url: 'https://github.com/niyazhashmi1105/seleniumautomationframework']])
                    bat 'mvn -Dmaven.test.failure.ignore=true clean package'
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
