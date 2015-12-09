package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

	Map<String, Member> members = null;
	
	public TddAirApplication() {
		members = new HashMap<String, Member>();
	}
	
	public void registerMember(String name) {
		if (name == null) throw new IllegalArgumentException("Member name cant be null!");
		if (members.containsKey(name)) throw new DuplicateMemberException("No Dupes!");
		
		Member newMember = new Member(name);
		newMember.setBalanceMiles(10000);
		newMember.setStatus(Status.RED);
		members.put(name, newMember);
	}

	public Member lookupMember(String name) {
		return members.get(name);
	}
	
}
