package com.tddair;

import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddApp = new TddAirApplication();
	private Member foundMember = null;
	private String errorMessage = null;

	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username)
			throws Throwable {
		try{
		tddApp.registerMember(username);
		}catch (DuplicateMemberException dme) {
			errorMessage = dme.getMessage();
		}
		foundMember = tddApp.lookupMember(username);
	}

	@Then("^should find a member with username \"([^\"]*)\"$")
	public void should_find_a_member_with_username(String username)
			throws Throwable {
		
		assertEquals("donmc", foundMember.getUsername());
	}

	@Then("^that member should have \"([^\"]*)\" status$")
	public void that_member_should_have_status(String status) throws Throwable {
		assertEquals(status.toLowerCase(), foundMember.getStatus().toString().toLowerCase());
	}

	@Then("^that member should have \"(\\d+)\" balance miles$")
	public void that_member_should_have_balance_miles(int balanceMiles)
			throws Throwable {
		assertEquals(balanceMiles, foundMember.getBalanceMiles());
	}

	@Then("^that member should have \"(\\d+)\" ytd miles$")
	public void that_member_should_have_ytd_miles(int ytdMiles) throws Throwable {
		assertEquals(ytdMiles, foundMember.getYTDMiles());
	}
	
	@Then("^should show error message \"([^\"]*)\"$")
	public void should_show_error_message(String message) throws Throwable {
	  
		assertEquals(message, errorMessage);
	}
}
