package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RegisterMemberTest {
	private TddAirApplication app;
	private String name;
	@Before
	public void setup(){
		app = new TddAirApplication();
	}
	
	
	@Test
	public void registerMemberDonMc(){
		name = "donmc";
		app.registerMember(name);
		
		assertEquals("donmc", app.lookupMember(name).getUsername());
	}
	
	@Test
	public void registerMemberNull(){
		try {
			app.registerMember(null);
			fail("Needs to throw IllegalArgumentException");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Member name cant be null!", iae.getMessage());
		}
	}
	
	@Test
	public void registerMemberHasZeroYTDMiles(){
		name = "donmc";
		app.registerMember(name);
		int miles =  app.lookupMember(name).getYTDMiles();
		assertEquals(0, miles);
	}
	
	@Test
	public void registerMemberHas10kBalanceMiles(){
		name = "donmc";
		app.registerMember(name);
		int miles =  app.lookupMember(name).getBalanceMiles();
		assertEquals(10000, miles);
	}
	
	@Test
	public void registerMemberHasRedStatus(){
		name = "donmc";
		app.registerMember(name);
		Status status =  app.lookupMember(name).getStatus();
		assertEquals(Status.RED, status);
	}
	
	@Test
	public void memberLookupNotFound(){
		name = "donmc";
		Member mbr = app.lookupMember(name);
		assertEquals(null, mbr);
		
	}
	
}
