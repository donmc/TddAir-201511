package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {

	private Map<String, Member> members = new HashMap<String, Member>();
	private static TddAirApplication tddApp = new TddAirApplication();

	private TddAirApplication() {
		
	}
	
	public static TddAirApplication getInstance() {
		return tddApp;
	}
	
	public static TddAirApplication newInstance() {
		return new TddAirApplication();
	}

	public void registerMember(String username) {
		if(members.containsKey(username)) throw new MemberException("Member With Username Already Exists");
		Member newMember = new Member(username);
		members.put(username, newMember);
	}

	public Member lookUpMember(String username) throws MemberException {
		Member member = members.get(username);
		if (member == null) {
			throw new MemberException("Member Not Found");
		}
		
		return member;
	}

	public void memberTakesFlight(String username, long l) throws MemberException {
		Member member = lookUpMember(username);
		
		member.addMiles(l);
	}

	public void upgradeByMiles(Member member, int numberOfUpgrades) throws UpgradeException{
			member.purchaseUpgradeByMiles(numberOfUpgrades);
	}

	public void upgradeByPayment(Member member, int numberOfUpgrades, String creditCard) {
		member.purchaseUpgradeByPayment(numberOfUpgrades, creditCard);
	}

}
