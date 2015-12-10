Feature: Track Miles
	As a frequent flier
	I want my miles tracked
	so that I can gain status levels for special priveleges
	
Scenario: Red to Green Status
	Given "RED" member "donmc" with "20000" ytd miles
	When they fly "5000" miles
	Then member "donmc" should have "GREEN" status
	And member "donmc" should have "25000" ytd miles
	And member "donmc" should have "35000" balance miles

	
