Feature: Register Member
	As a frequent flyer
	I want to register as a member
	so that I can collect miles and get perks

Scenario: Save New Memebrs
	When registering a new member with username "donmc"
	Then should find a member with username "donmc"
	And that member should have "RED" status
	And that member should have "10000" balance miles
	And that member should have "0" ytd miles
	
Scenario: Duplicate UserNames
	When registering a new member with username "donmc"
	And registering a new member with username "donmc"
	Then should show error message "No Dupes!"
