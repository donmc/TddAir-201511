Feature: Track Miles
	As a frequent flier
	I want my miles tracked
	so that I can gain status levels for special priveleges
	
Scenario: Red to Green Status
	Given a "RED" status member with "20000" ytd miles
	When they fly "5000" miles
	Then that member should have "GREEN" status
	And that member should have "25000" ytd miles
	