package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;

public class CommonSteps {
	
	private static Member member;
	
	@Then("^the member should be \"([A-Z]+)\" status$")
	public void the_member_should_be_status(String status) throws Throwable {
		assertEquals(status, member.getStatus().toString());
	}

	@Then("^the member should have \"(\\d+)\" YTD miles$")
	public void the_member_should_have_YTD_miles(long ytd) throws Throwable {
		assertEquals(Long.valueOf(ytd), member.getYTDMiles());
	}

	@Then("^the member should have \"(\\d+)\" balance miles$")
	public void the_member_should_have_balance_miles(long balance) throws Throwable {
		assertEquals(Long.valueOf(balance), member.getBalance());
	}

	public static void setMember(Member mem) {
		member = mem;
	}
}
