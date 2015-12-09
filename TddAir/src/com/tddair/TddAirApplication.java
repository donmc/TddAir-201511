package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {

	private Map<String, Member> members = new HashMap<String, Member>();

	public TddAirApplication() {
		
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

}
