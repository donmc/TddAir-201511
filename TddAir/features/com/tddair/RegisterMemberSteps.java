package com.tddair;

import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddapp = new TddAirApplication();
	private Member member;
	
	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username) throws Throwable {
	    tddapp.registerMember(username);
	    member = tddapp.lookupMember(username);
	}

	@Then("^should find a member with username \"([^\"]*)\"$")
	public void should_find_a_member_with_username(String username) throws Throwable {
	    Assert.assertEquals(username, member.getUsername());
	}

	@Then("^new member should have \"([^\"]*)\" status$")
	public void new_member_should_have_status(String status) throws Throwable {
	    Assert.assertEquals(status, member.getStatus().toString());
	}

	@Then("^new member should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(int balanceMiles) throws Throwable {
	    Assert.assertEquals(balanceMiles, member.getBalance());
	}

	@Then("^new member should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(String ytdMiles) throws Throwable {
		Assert.assertEquals(ytdMiles, member.getYtdMiles());
	}
	
	@Then("^should show error message$")
	public void should_show_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
