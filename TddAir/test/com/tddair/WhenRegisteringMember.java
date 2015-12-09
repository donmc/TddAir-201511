package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringMember {
	
	private Member member;
	private TddAirApplication app;
	
	@Before
	public void setup() {
		app = new TddAirApplication();
		app.registerMember("donmc");
		member = app.lookupMember("donmc");
	}

	@Test
	public void shouldSaveMember() {
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveCorrectUserName() {
		assertEquals("donmc", member.getUsername());
	}
	
	@Test
	public void shouldRegister2Members() {
		app.registerMember("bobby");
		Member bobby = app.lookupMember("bobby");
		assertEquals("bobby", bobby.getUsername());
	}
	
	@Test
	public void shouldStartNewMembersWithRedStatus() {
		assertEquals(Status.RED, member.getStatus());
	}
	
	@Test
	public void shouldStartNewMembersWith0YtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void shouldStartNewMembersWith10000BalanceMiles() {
		assertEquals(10000, member.getBalance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWhenLookingUpUnregisteredMember() {
		app.lookupMember("batman");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWhenRegisteringDuplicateUsername() {
		app.registerMember("santa");
		app.registerMember("santa");
	}

}
