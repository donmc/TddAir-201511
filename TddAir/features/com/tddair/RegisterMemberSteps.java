package com.tddair;

import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddapp = new TddAirApplication();
	private Member member;
	private String errorMessage;
	
	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username) throws Throwable {
    	try {
			tddapp.registerMember(username);
			member = tddapp.lookupMember(username);
		} catch (IllegalArgumentException e) {
			this.errorMessage = e.getMessage();
		}
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
	
	@Then("^should show error message \"([^\"]*)\"$")
	public void should_show_error_message(String errorMessage) throws Throwable {
	    Assert.assertEquals(errorMessage, this.errorMessage);
	}

}
