package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberBehavior {
	private Member member;

	@Test
	public void memberShouldHaveUsername() {
		member = new Member("myUsername");
		assertEquals("myUsername", member.getUsername());
	}
	
	@Test
	public void memberShouldHaveRedStatus() {
		member = new Member("redStatusBehavior");
		assertEquals(Status.RED, member.getStatus());
	}
	
	@Test
	public void memberShouldHaveBonusMiles() {
		member = new Member("bonusMilesBehavior");
		assertEquals(10000, member.getBalance());
	}
	
	@Test
	public void memberShouldHaveYtdMiles() {
		member = new Member("ytdMilesBehavior");
		assertEquals(0, member.getYtdMiles());
	}

}
