Feature: Register Member
As a frequent flyer I want to be able to track my miles so that I can gain status levels for special priviledges.
	
  Scenario: Tracking Member Miles
    Given a member with "RED" status with "20000" year to date miles
    When member flies "5000" miles
	Then member status should be upgraded to "GREEN"
	And member new mile balance should be "25000"