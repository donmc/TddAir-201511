package com.tddair;

import java.util.HashMap;

public class TddAirApplication {
  private HashMap<String, Member> memberList = new HashMap<String, Member>();
  
  public void registerMember(String username) {
	  memberList.put(username, new Member(username));
  }
  
  public String lookupMember(String username) {
	  return memberList.get(username).getUsername();
  }
  
  public String getMemberStatus(String username) {
	  return memberList.get(username).getStatus();
  }

}
