package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	private TddAirApplication tddApp = TddAirApplication.getInstance();
	private Member member;
	private Exception e;

	@When("^registering a new member with username \"([a-zA-Z0-9]+)\"$")
	public void registering_a_new_member_with_username(String username) throws Throwable {
		try {
			tddApp.registerMember(username);
			member = tddApp.lookUpMember(username);
			assertNotNull(member);
		} catch (Exception e) {
			this.e = e;
		}
		
		CommonSteps.setMember(member);
	}

	@Then("^lookup should find a member with username \"([a-zA-Z0-9]+)\"$")
	public void lookup_should_find_a_member_with_username(String username) throws Throwable {
		member = tddApp.lookUpMember(username);
		assertEquals(username, member.getUsername());
		CommonSteps.setMember(member);
	}
	
	@Then("^should show error message \"([^\"]*)\"$")
	public void should_show_error_message(String error) throws Throwable {
		assertEquals(error, e.getMessage());
	}
	
}
