package com.tddair;

import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrackMilesSteps {
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	
	@Given("^a \"([^\"]*)\" member with \"([^\"]*)\" ytd miles$")
	public void a_member_with_ytd_miles(Status status, int ytdMiles) throws Throwable {
	    app.registerMember("testMember");
	    member = app.lookupMember("testMember");
	    member.setStatus(status);
	    member.setYtdMiles(ytdMiles);
	}

	@When("^they fly \"([^\"]*)\" miles$")
	public void they_fly_miles(int milesFlown) throws Throwable {
	    app.logFlight(member.getUsername(), milesFlown);
	}

	@Then("^that member should have \"([^\"]*)\" status$")
	public void that_member_should_have_status(String status) throws Throwable {
	    Assert.assertEquals(status, member.getStatus());
	}

	@Then("^that member should have \"([^\"]*)\" ytd miles$")
	public void that_member_should_have_ytd_miles(String ytdMiles) throws Throwable {
		Assert.assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^that member should have \"([^\"]*)\" balance miles$")
	public void that_member_should_have_balance_miles(String balanceMiles) throws Throwable {
		Assert.assertEquals(balanceMiles, member.getBalance());
	}

}
