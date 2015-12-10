package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PurchaseUpgradeBehavior {
	
	private TddAirApplication tddApp = TddAirApplication.newInstance();
	
	@Test
	public void purchaseByMiles(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		long initialBalance = member.getBalance();
		int initialUpgrades = member.getUpgrades();
		MemberStatus status = member.getStatus();
		
		tddApp.upgradeByMiles(member, 1);
		
		assertEquals(initialBalance-status.getUpgradeMilesCost(), member.getBalance().longValue());
		assertEquals(initialUpgrades+1, member.getUpgrades());
	}
	
	@Test
	public void purchaseByMilesWhenGreenStatus(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		tddApp.memberTakesFlight("sarahmk", 26000);
		long initialBalance = member.getBalance();
		int initialUpgrades = member.getUpgrades();
		MemberStatus status = member.getStatus();
		
		tddApp.upgradeByMiles(member, 1);
		
		assertEquals(initialBalance-status.getUpgradeMilesCost(), member.getBalance().longValue());
		assertEquals(initialUpgrades+1, member.getUpgrades());
	}
	
	@Test
	public void purchaseByMilesWhenNotEnoughBalance(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		member.setBalance(0);
		
		try {
			tddApp.upgradeByMiles(member, 1);
			fail();
		} catch (UpgradeException e) {
			assertEquals("Not enough balance", e.getMessage());
		}
	}
	
	@Test
	public void purchaseByMilesWhenNotEnoughBalance_Numbers(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		member.setBalance(0);
		long initialBalance = member.getBalance();
		int initialUpgrades = member.getUpgrades();
		
		try {
			tddApp.upgradeByMiles(member, 1);
			fail();
		} catch (UpgradeException e) {
			assertEquals(initialBalance, member.getBalance().longValue());
			assertEquals(initialUpgrades, member.getUpgrades());
		}
	}
	
	@Test
	public void purchaseByMilesMultiple(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		tddApp.memberTakesFlight("sarahmk", 50000);
		long initialBalance = member.getBalance();
		int initialUpgrades = member.getUpgrades();
		MemberStatus status = member.getStatus();
		
		tddApp.upgradeByMiles(member, 2);
		
		assertEquals(initialBalance-status.getUpgradeMilesCost()*2, member.getBalance().longValue());
		assertEquals(initialUpgrades+2, member.getUpgrades());
	}
	
	@Test
	public void purchaseWithCreditCard(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		int initialUpgrades = member.getUpgrades();
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String goodCreditCard = "1234567812345678";
		tddApp.upgradeByPayment(member, 1, goodCreditCard);
		
		assertEquals(initialUpgrades+1, member.getUpgrades());
		assertEquals(100, cas.getAmountCharged());
	}
	
	@Test
	public void purchaseWithCreditCardThree(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String goodCC = cas.GOOD_CC;
		tddApp.upgradeByPayment(member, 3, goodCC);
		
		assertEquals(3, member.getUpgrades());
		assertEquals(300, cas.getAmountCharged());
	}
	
	@Test
	public void purchaseWithInvalidCreditCard(){
		tddApp.registerMember("sarahmk");
		Member member = tddApp.lookUpMember("sarahmk");
		SpyCreditAuthorizationService cas = new SpyCreditAuthorizationService();
		member.setCas(cas);
		
		String badCC = cas.BAD_CC;
		tddApp.upgradeByPayment(member, 3, badCC);
		
		assertEquals(0, member.getUpgrades());
		assertEquals(300, cas.getAmountCharged());
	}
}
