package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

	Map<String, Member> members = null;
	
	public TddAirApplication() {
		members = new HashMap<String, Member>();
	}
	
	public Member registerMember(String name) {
		if (name == null) throw new IllegalArgumentException("Member name cant be null!");
		if (members.containsKey(name)) throw new DuplicateMemberException("No Dupes!");
		
		Member newMember = new Member(name);
		members.put(name, newMember);
		return newMember;
	}

	public Member lookupMember(String name) {
		return members.get(name);
	}

	public void updateMilesFlown(String member, int miles) {
		Member mbr =  this.lookupMember(member);
		mbr.addMilesFlown(miles);
		
	}

	public int getYtdMilesFlownByMember(String member) {
		// TODO Auto-generated method stub
		return lookupMember(member).getYtdMiles();
	}
	
}
