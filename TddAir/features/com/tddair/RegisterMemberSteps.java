package com.tddair;

import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddApp;
	private Member foundMember = null;
	private String errorMessage = null;

	public RegisterMemberSteps() {
		tddApp = TddAirSingleton.getTddAirAplication();
	}
	
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

	@Then("^member \"([^\"]*)\" should have \"([^\"]*)\" status$")
	public void that_member_should_have_status(String userName, String status) throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		assertEquals(status.toLowerCase(), aMember.getStatus().toString().toLowerCase());
	}

	@Then("^member \"([^\"]*)\" should have \"(\\d+)\" balance miles$")
	public void that_member_should_have_balance_miles(String userName, int balanceMiles)
			throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		assertEquals(balanceMiles, aMember.getBalanceMiles());
	}

	@Then("^member \"([^\"]*)\" should have \"(\\d+)\" ytd miles$")
	public void that_member_should_have_ytd_miles(String userName, int ytdMiles) throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		assertEquals(ytdMiles, aMember.getYtdMiles());
	}
	
	@Then("^should show error message \"([^\"]*)\"$")
	public void should_show_error_message(String message) throws Throwable {
		assertEquals(message, errorMessage);
	}
}
