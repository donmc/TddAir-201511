package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

	@Test
	public void shouldPurchaseSeatUpgradeWithMiles() {
		Member member = new Member("donmc");
		
		member.purchaseSeatUpgradeWithMiles(1);
		
		assertEquals(0, member.getBalanceMiles());
		assertEquals(0, member.getYtdMiles());
		assertEquals(1, member.getSeatUpgradeCount());
	}
	
	@Test
	public void shouldPurchase2SeatUpgradeWithMiles() {
		Member member = new Member("donmc");
		member.addMilesFlown(15000);
		member.purchaseSeatUpgradeWithMiles(2);
		
		assertEquals(5000, member.getBalanceMiles());
		assertEquals(2, member.getSeatUpgradeCount());
	}
	
	@Test
	public void shouldPurchaseSeatUpgradeWithMiles_Green() {
		Member member = new Member("donmc");
		
		member.addMilesFlown(25000);
		
		member.purchaseSeatUpgradeWithMiles(1);
		
		assertEquals(35000-9000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldPurchaseSeatUpgradeWithCredit() {
		Member member = new Member("donmc");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		
		member.setCas(cas);
		
		member.purchaseSeatUpgradeWithCreditCard(1, SpyCreditAuthorizationService.GOOD_CC);
		
		assertEquals(1, member.getSeatUpgradeCount());
		assertEquals(100, cas.getAmountCharged());
	}
	
	@Test
	public void shouldPurchase3SeatUpgradeWithCredit() {
		Member member = new Member("donmc");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		
		member.setCas(cas);
		
		member.purchaseSeatUpgradeWithCreditCard(3, SpyCreditAuthorizationService.GOOD_CC);
		
		assertEquals(3, member.getSeatUpgradeCount());
		assertEquals(300, cas.getAmountCharged());
	}
	
	@Test
	public void shouldNotPurchaseSeatUpgradeWithInvalidCC() {
		Member member = new Member("donmc");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		
		member.setCas(cas);
		
		member.purchaseSeatUpgradeWithCreditCard(1, SpyCreditAuthorizationService.BAD_CC);
		
		assertEquals(0, member.getSeatUpgradeCount());
	}
}
