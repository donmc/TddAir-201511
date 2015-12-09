package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class TddAirApplicationBehavior {
	private TddAirApplication tddAirTestObject = new TddAirApplication();

	@Test
	public void memberShouldBeRegistered() {
		tddAirTestObject.registerMember("myUsername");
		assertEquals("myUsername", tddAirTestObject.lookupMember("myUsername"));
	}
	
	@Test
	public void memberShouldHaveRedStatus() {
		tddAirTestObject.registerMember("redStatusBehavior");
		assertEquals("RED", tddAirTestObject.getMemberStatus("redStatusBehavior"));
	}
	
	@Test
	public void memberShouldHaveBonusMiles() {
		tddAirTestObject.registerMember("redStatusBehavior");
		assertEquals(10000, tddAirTestObject.getMemberCurrentBalance());
	}

}
