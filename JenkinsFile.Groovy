pipeline {

    agent any
	
    
    stages {
        
        stage("git-poll"){
        
            steps {
                echo 'Downloading the Repository...'
				git changelog: false,
				url: 'https://github.com/CharlesPikachu/Games/tree/master/Game7'
            }
	}
        stage("Rename-Game"){
        
            steps {
                echo 'Renaming "Game7" to "Dino DevOps"...'


			

            }
	}
        stage("Zip the Game"){
        
            steps {
                echo 'deploying the application...'
				
			}
		
    }
		
        }
    }