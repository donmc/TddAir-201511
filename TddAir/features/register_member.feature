Feature: Register Member
	As a frequent flier
	I want to register as a member
	so that I can collect miles and get perks

Scenario: Save New Members
	When registering a new member with username "sarahmk"
	Then lookup should find a member with username "sarahmk"
	And the member should be "RED" status
	And the member should have "0" YTD miles
	And the member should have "10000" balance miles

Scenario: Duplicate Usernames
	When registering a new member with username "stevenb"
	And registering a new member with username "stevenb"
	Then should show error message "Member With Username Already Exists"
 