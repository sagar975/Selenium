Feature: Login featuretest 

Scenario Outline: test the login functionality with positive test cases 

	Given  navigate to applicatiom freeCrm 
	When  enter valid credentials <username> and password <pwd> 
	Then  user should be on homepage of application 
	
	
	
	Examples: 
	
		|username|pwd| 
		|sagarsonawane1991@gmail.com|Sagar123|
		|sagarsonawane1991@gmail.com|dummy|
		|sagarsonawane1991@gmail.com|dummy456|
		
		
		
		
		
		
		