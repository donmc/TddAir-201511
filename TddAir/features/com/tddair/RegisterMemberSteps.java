package com.tddair;

import static org.junit.Assert.assertEquals;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddApp = new TddAirApplication();

	@When("^registering a new member with username \"([a-zA-Z0-9]+)\"$")
	public void registering_a_new_member_with_username(String arg1) throws Throwable {
		tddApp.registerMember("sarahmk");
	}

	@Then("^lookup should find a member with username \"([a-zA-Z0-9]+)\"$")
	public void lookup_should_find_a_member_with_username(String arg1) throws Throwable {
		tddApp.registerMember("sarahmk");
		Member memberSarah = tddApp.lookUpMember("sarahmk");
		assertEquals("sarahmk", memberSarah.getUsername());
	}

	@Then("^new member should have \"([A-Z]+)\" status$")
	public void new_member_should_have_status(String arg1) throws Throwable {
		tddApp.registerMember("sarahmk");
		Member memberSarah = tddApp.lookUpMember("sarahmk");
		MemberStatus status = memberSarah.getStatus();
		assertEquals(MemberStatus.RED, status);
	}

	@Then("^new member should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(String arg1) throws Throwable {
		tddApp.registerMember("sarahmk");
		Member memberSarah = tddApp.lookUpMember("sarahmk");
		Long balance = memberSarah.getBalance();
		assertEquals(Long.valueOf(10000), balance);
	}

	@Then("^new member should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(String arg1) throws Throwable {
		tddApp.registerMember("sarahmk");
		Member memberSarah = tddApp.lookUpMember("sarahmk");
		Long ytd = memberSarah.getYTDMiles();
		assertEquals(Long.valueOf(0), ytd);
	}
	
}
