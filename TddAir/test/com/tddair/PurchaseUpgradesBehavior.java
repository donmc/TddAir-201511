package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class PurchaseUpgradesBehavior {
	Member member = new Member("upgradePurchaser");
	member.purchaseUpgradeWithMiles();

	@Test
	public void seatShouldBeUpgraded() {
		assertEquals(true, member.getSeatUpgrade());
	}
	
	@Test
	public void balanceShouldDecreaseBy10000() {
		assertEquals(0, member.getBalance());
	}
	
	@Test
	public void ytdShouldRemainTheSame() {
		assertEquals(0, member.getYtdMiles());
	}

}
