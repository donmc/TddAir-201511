Feature: Track Miles
	As a frequent flier	I want my miles tracked	so that I can gain status levels for special privileges
	
Scenario: Upgrade to Green Status
	Given a "RED" member with "24800" ytd miles
	When they fly "680" miles
	Then that member should have "GREEN" status
	And that member should have "25480" ytd miles
	And that member should have "35480" balance miles
	
Scenario: Upgrade to Blue Status
	Given a "GREEN" member with "49800" ytd miles
	When they fly "400" miles
	Then that member should have "BLUE" status
	And that member should have "50200" ytd miles
	And that member should have "60200" balance miles

Scenario: Upgrade to Gold Status	
	Given a "BLUE" member with "70000" ytd miles
	When they fly "5001" miles
	Then that member should have "75001" ytd miles
	And that member should have "85001" balance miles
	And that member should have "GOLD" status
	