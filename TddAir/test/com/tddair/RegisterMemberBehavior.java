package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RegisterMemberBehavior {
	
	private TddAirApplication tddApp = new TddAirApplication();
	private Member memberSarah;
	private Member memberSteven;
	
	@Before
	public void setup(){
		tddApp.registerMember("sarahmk");
		tddApp.registerMember("steveb");
		
		memberSarah = tddApp.lookUpMember("sarahmk");
		memberSteven = tddApp.lookUpMember("steveb");
	}

	@Test
	public void shouldFindMemberWithUsername() {
		assertEquals("steveb", memberSteven.getUsername());
	}
	
	@Test
	public void shouldFindMembersWithUsernames() {
		assertEquals("sarahmk", memberSarah.getUsername());
	}
	
	@Test
	public void shouldNotFindMemberNotRegistered() {
		try {
			tddApp.lookUpMember("bob");
			fail();
		} catch (MemberNotFoundException e) {
			assertEquals("Member Not Found", e.getMessage());
		}
	}

	@Test
	public void shouldHaveRedStatus() {
		MemberStatus status = memberSarah.getStatus();
		assertEquals(MemberStatus.RED, status);
	}
	
	@Test
	public void shouldHave10000BalanceMiles() {
		Long balance = memberSarah.getBalance();
		assertEquals(Long.valueOf(10000), balance);
	}
	
	@Test
	public void shouldHave0YTDMiles() {
		Long ytd = memberSarah.getYTDMiles();
		assertEquals(Long.valueOf(0), ytd);
	}
}
