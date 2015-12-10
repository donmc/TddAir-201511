package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TddAirApplicationTest {

	TddAirApplication airApp = null;
	private Member member;
	
	@Before
	public void setup() {		
		airApp = new TddAirApplication();
		airApp.registerMember("teamb");
		member = airApp.retrieveMember("teamb");
	}
	
	
	@Test
	public void testMemberCreation() {
		//setup
		String username = "teamb";
		//Validate
		assertEquals(username,airApp.retrieveMember(username).getUsername());
	}

	@Test
	public void shouldRegister2Members() {
		airApp.registerMember("Bobby");
		Member Bobby = airApp.retrieveMember("Bobby");
		assertEquals("Bobby", Bobby.getUsername());
	}
	
	@Test
	public void testMemberRetrieval() {
		String username = "teamb";
		assertEquals(username, member.getUsername());
	}
	
	@Test
	public void testMemberStartingYtdMilesIsZero()
	{	
		int starting = 0;
		int ytdMiles = member.getYtdMiles();
		assertEquals(starting, ytdMiles);
	}

	@Test
	public void testMemberStartingBalanceMilesIs10000()
	{
		int bonus = 10000;
		int balanceMiles = member.getBalanceMiles();
		assertEquals(bonus, balanceMiles);
	}

	@Test
	public void shouldStartNewMembersWithRedStatus() {
		assertEquals(Status.RED, member.getStatus());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWhenLookingUpUnregisteredMember() {
		airApp.retrieveMember("batman");
	}
	
	@Test(expected=MemberAlreadyExistsException.class) 
	public void testMemberCreationAlreadyExists() {
		airApp.registerMember("teamb");
	}
}

