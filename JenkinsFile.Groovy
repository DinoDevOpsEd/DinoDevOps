pipeline {

    agent any
	
    
    stages {
        
        stage("git-poll"){
			
			token="AAAAB3NzaC1yc2EAAAADAQABAAABAQC6JbdPbjJbJrc/KyXYv9FCy04Dnk5EPi4ft9ONEr2fttO4Ozyz0UzDUlMsE3r94as6cvxLdR049KoZRjDRLjOGvBfbf6DtlQy3i/FnDiB8jgYQFxRyuJgKUvnXKSLLdZ/SItxTEaftX2LY/xK/9ILFGHjDlvT3e/ghjfR57a9jHiNVf+LKpzNfD61/tnlavFM3eEMvzzBK+ZUGcEx8h1TI1CHZCCsSbTE27zRm+1VS5c7UEKaNXj9e6ybYYKWtxh00CS+zARLVUVF/13OXEYB34GQbB3M2pPUemhcbobpDQnKXqQoG0IOCXhAHC+s7N63PBzVbCO0fmZKo72B6Ht9B walas@DESKTOP-S3L6JC5"
			

			        
            steps {
                echo 'Downloading the Repository...'
				git changelog: false,
				url: 'https://github.com/CharlesPikachu/Games/'
            }
	}
        stage("Rename-Game"){
        
            steps {
                echo 'Renaming "Game7" to "Dino DevOps"...'


			

            }
	}
        stage("Zip the Game"){
        
            steps {
                echo 'Compressing the application...'
				zip -r DinoDevOps.zip ./
			}
		
    }
		stage("publish"){
			
				steps {
					release=$(curl -XPOST -H "Authorization:token $token" --data "{\"tag_name\": \"Build\", \"target_commitish\": \"Branch1\", \"name\": \"Dino DevOps\", \"body\": \"1.0\", \"draft\": false, \"prerelease\": true}" https://api.github.com/repos/EdgardoNogueira/DinoDevOps/releases)
				}
			
		}

        }
    }