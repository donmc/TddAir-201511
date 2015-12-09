package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddApp = new TddAirApplication();
	private Member member;

	@When("^registering a new member with username \"([a-zA-Z0-9]+)\"$")
	public void registering_a_new_member_with_username(String username) throws Throwable {
		tddApp.registerMember(username);
		member = tddApp.lookUpMember(username);
		assertNotNull(member);
	}

	@Then("^lookup should find a member with username \"([a-zA-Z0-9]+)\"$")
	public void lookup_should_find_a_member_with_username(String username) throws Throwable {
		member = tddApp.lookUpMember(username);
		assertEquals(username, member.getUsername());
	}

	@Then("^new member should have \"([A-Z]+)\" status$")
	public void new_member_should_have_status(String memberStatus) throws Throwable {
		assertEquals(memberStatus, member.getStatus().toString());
	}

	@Then("^new member should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(Long memberBalance) throws Throwable {
		assertEquals(memberBalance, member.getBalance());
	}

	@Then("^new member should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(Long memberYTD) throws Throwable {
		assertEquals(memberYTD, member.getYTDMiles());
	}
	
}
