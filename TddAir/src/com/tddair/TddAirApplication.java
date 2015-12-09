package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {

	private Map<String, Member> members = new HashMap<String, Member>();

	public TddAirApplication() {
		
	}

	public void registerMember(String username) {
		Member newMember = new Member(username);
		members.put(username, newMember);
	}

	public Member lookUpMember(String username) throws MemberNotFoundException {
		Member member = members.get(username);
		if (member == null) {
			throw new MemberNotFoundException("Member Not Found");
		}
		
		return member;
	}

}
