Feature: Login featuretest 

Scenario Outline: test the login functionality with positive test cases 

	Given  navigate to application url 
	When     enter valid credentials <username> and password <pwd> 
	Then     user should be on homepage of application 
	
	
	
	Examples: 
	
		|username|pwd| 
		|sagar91|12345|
		|sagar92|56789|
		|sagar96|1010101|
		
		
		
		
		