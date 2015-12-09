package com.tddair;

import java.util.HashMap;

public class TddAirApplication {
  private HashMap<String, Member> memberList = new HashMap<String, Member>();
  
  public void registerMember(String username) {
	  if(memberList.containsKey(username)) throw new IllegalArgumentException("No Dupes!");
	  memberList.put(username, new Member(username));
  }
  
  public Member lookupMember(String username) {
	  if (!memberList.containsKey(username)) throw new IllegalArgumentException();
	  return memberList.get(username);
  }
  
  public Status getMemberStatus(String username) {
	  return memberList.get(username).getStatus();
  }
  
  public int getMemberCurrentBalance(String username) {
	  return memberList.get(username).getBalance();
  }
  
  public int getMemberYtdMiles(String username) {
	  return memberList.get(username).getYtdMiles();
  }
 
}
