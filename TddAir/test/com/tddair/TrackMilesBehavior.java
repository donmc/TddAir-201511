package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TrackMilesBehavior {
	
	private TddAirApplication tddApp = TddAirApplication.newInstance();
	private Member memberSarah;
	
	@Before
	public void setupMember(){
		tddApp.registerMember("sarahmk");
		memberSarah = tddApp.lookUpMember("sarahmk");
	}
	
	@Test
	public void upgradeRedToGreen(){
		memberSarah.setBalance(32000L);
		memberSarah.setYTDMiles(22000L);
		
		tddApp.memberTakesFlight("sarahmk", 4000L);
		
		assertEquals(MemberStatus.GREEN, memberSarah.getStatus());
	}
	
	@Test
	public void redToGreenBalance(){
		memberSarah.setBalance(32000L);
		memberSarah.setYTDMiles(22000L);
		
		tddApp.memberTakesFlight("sarahmk", 4000L);
		
		assertEquals(Long.valueOf(36000), memberSarah.getBalance());
	}
	
	@Test
	public void redToGreenYTD(){
		memberSarah.setBalance(32000L);
		memberSarah.setYTDMiles(22000L);
		
		tddApp.memberTakesFlight("sarahmk", 4000L);
		
		assertEquals(Long.valueOf(26000), memberSarah.getYTDMiles());
	}
	
	@Test
	public void upgradeRedToBlue(){
		memberSarah.setBalance(32000L);
		memberSarah.setYTDMiles(22000L);
		
		tddApp.memberTakesFlight("sarahmk", 29000L);
		
		assertEquals(MemberStatus.BLUE, memberSarah.getStatus());
	}
}
