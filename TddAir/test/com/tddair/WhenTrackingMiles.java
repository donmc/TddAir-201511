package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenTrackingMiles {
	
	private TddAirApplication app;
	private Member mbr = null;
	@Before
	public void setup(){
		app = new TddAirApplication();
	}
	
	@Test
	public void shouldUpdateYtdMilesWhenFlown() {
		app.registerMember("donmc");
		this.mbr = app.lookupMember("donmc");
		this.mbr.addMilesFlown(5000);
		assertEquals(5000, mbr.getYtdMiles());
	}
	
	@Test
	public void shouldUpdateBalanceMilesWhenFlown() {
		app.registerMember("donmc");
		this.mbr = app.lookupMember("donmc");
		this.mbr.addMilesFlown(5000);
		assertEquals(15000, mbr.getBalanceMiles());
	}
	
	@Test
	public void shouldUpdateStatusMilesWhenFlownGreen() {
		app.registerMember("donmc");
		this.mbr = app.lookupMember("donmc");
		this.mbr.addMilesFlown(25000);
		assertEquals(Status.GREEN, mbr.getStatus());
	}
	
	@Test
	public void shouldUpdateStatusMilesWhenFlownBlue() {
		app.registerMember("donmc");
		this.mbr = app.lookupMember("donmc");
		this.mbr.addMilesFlown(50000);
		assertEquals(Status.BLUE, mbr.getStatus());
	}
	
	@Test 
	public void shouldNotUpdateWithNegativeFlightMiles(){
		app.registerMember("donmc");
		this.mbr = app.lookupMember("donmc");
		try{
			this.mbr.addMilesFlown(-125);
			fail("Negative miles flown not allowed!");
		}catch(IllegalArgumentException iae){
			
		}
	}
	

}
