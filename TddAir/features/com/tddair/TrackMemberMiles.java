package com.tddair;

import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrackMemberMiles {

	TddAirApplication app = new TddAirApplication();
	Member member = null;
	
	@Given("^a member with \"([^\"]*)\" status with \"([^\"]*)\" year to date miles$")
	public void a_member_with_status_with_year_to_date_miles(String status, int ytdMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		member = app.registerMember("testmember");
		app.addMiles(member.getUsername(), ytdMiles);
		Assert.assertEquals(20000, member.getYtdMiles());
		Assert.assertEquals(status, member.getStatus().toString());
	}

	@When("^member flies \"([^\"]*)\" miles$")
	public void member_flies_miles(int addedMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    int ytdMiles = member.getYtdMiles();
	    app.addMiles(member.getUsername(), addedMiles);
	    Assert.assertEquals(25000, member.getYtdMiles());
	}

	@Then("^member status should be upgraded to \"([^\"]*)\"$")
	public void member_status_should_be_upgraded_to(String statusUpgrade) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(Status.RED, member.getStatus());
	}

	@Then("^member new mile balance should be \"([^\"]*)\"$")
	public void member_new_mile_balance_should_be(int ytdMiles) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(member.getYtdMiles(), ytdMiles);
	}
	
}
