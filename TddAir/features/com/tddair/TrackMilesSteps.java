package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;

public class TrackMilesSteps {
	
	private TddAirApplication tddApp = TddAirApplication.getInstance();
	private Member member;
	private String username;
	
	@Given("^a member with username \"([a-zA-Z0-9]+)\" and \"(\\d+)\" YTD miles and \"(\\d+)\" balance miles$")
	public void a_member_with_YTD_miles_and_balance_miles(String username, long ytd, long balance) throws Throwable {
		this.username = username;
		this.tddApp = TddAirApplication.newInstance();
		
		tddApp.registerMember(username);
		member = tddApp.lookUpMember(username);
		member.setYTDMiles(ytd);
		member.setBalance(balance);
		
		CommonSteps.setMember(member);
	}

	@When("^member flies \"(\\d+)\" miles$")
	public void member_flies_miles(long miles) throws Throwable {
		tddApp.memberTakesFlight(username, miles);
	}
}
