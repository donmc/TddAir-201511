Feature: Track Miles
	As a frequent flier
	I want my miles tracked
	so that I can gain status levels for special privileges
	
Scenario: Upgrade to Green Status
	Given Red Member
	And 24800 ytd miles
	And 34800 miles balance
	When they complete a flight with 680 miles
	Then status should update to Green
	And ytd miles should update to 25480
	And miles balance should update to 35480
	
Scenario: Upgrade to Blue Status
	Given Green member
	And 49800 ytd miles
	And 59800 miles balance
	When they complete a flight with 400 miles
	Then status should update to Blue
	And ytd miles should update to 50200
	And miles balance should update to 60200

Scenario: Upgrade to Gold Status	
	Given Blue member
	And 70000 ytd miles
	And 70000 miles balance
	When they complete a flight with 5001 miles
	Then ytd miles should update to 75001
	And miles balance should update to 75001
	And status should update to Gold
	