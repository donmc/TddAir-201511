package com.tddair;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddapp = new TddAirApplication();
	
	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^should find a member with username \"([^\"]*)\"$")
	public void should_find_a_member_with_username(String username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^new member should have \"([^\"]*)\" status$")
	public void new_member_should_have_status(String status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^new member should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(int balanceMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^new member should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(String ytdMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
