package com.tddair;

import java.util.HashMap;

public class TddAirApplication {

	HashMap <String, Member> members = null;
	
	public TddAirApplication() {
		members = new HashMap<String, Member>();
	}
	
	public void registerMember(String name) {
		if (name == null) throw new IllegalArgumentException("Member name cant be null!");
		
		Member newMember = new Member(name);
		newMember.setBalanceMiles(10000);
		newMember.setStatus(Status.RED);
		members.put(name, newMember);
	}

	public Member lookupMember(String name) {
		return members.get(name);
	}
	
}
