Feature: Track Miles
	As a frequent flyer
	I want my miles tracked
	So that I can gain status levels for perks
	
Scenario: Still RED Status
	Given a member with username "sarahmk" and "20000" YTD miles and "10000" balance miles
	When member flies "4999" miles
	Then the member should be "RED" status
	And the member should have "24999" YTD miles
	And the member should have "14999" balance miles

Scenario: Earn GREEN Status
	Given a member with username "sarahmk" and "22000" YTD miles and "32000" balance miles
	When member flies "4000" miles
	Then the member should be "GREEN" status
	And the member should have "26000" YTD miles
	And the member should have "36000" balance miles
	
Scenario: Earn BLUE Status
	Given a member with username "steveB" and "27000" YTD miles and "2000" balance miles
	When member flies "30000" miles
	Then the member should be "BLUE" status
	And the member should have "57000" YTD miles
	And the member should have "32000" balance miles
	
Scenario: Earn GOLDEN Status
	Given a member with username "steveB" and "70000" YTD miles and "42000" balance miles
	When member flies "10000" miles
	Then the member should be "GOLDEN" status
	And the member should have "80000" YTD miles
	And the member should have "52000" balance miles