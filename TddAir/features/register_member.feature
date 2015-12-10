Feature: Register Member
As a frequent flyer I want to register as a member so that I can collect miles and get perks
	
  Scenario: Save New Members
	When registering a new member with username "teamb"
	Then should find a member with username "teamb"
	And new member should have "RED" status
	And new member should have "10000" balance miles
	And new member should have "0" ytd miles
	
  Scenario: Duplicate Usernames
	When registering a new member with username "teamb"
	And registering a new member with username "teamb"
	Then should show error messages "Yo, this guy already exists!"