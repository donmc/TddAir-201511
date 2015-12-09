package com.tddair;

import java.util.ArrayList;
import java.util.List;

public class TddAirApplication {

	private List<Member> members = new ArrayList<Member>();

	public TddAirApplication() {
		
	}

	public void registerMember(String username) {
		Member newMember = new Member(username);
		members.add(newMember);
	}

	public Member lookUpMember(String username) throws MemberNotFoundException {
		Member member = null;
		for(Member x : members){
			if(x.getUsername().equals(username)){
				member = x;
			}
		}
		
		if (member == null) {
			throw new MemberNotFoundException("Member Not Found");
		}
		
		return member;
	}

}
