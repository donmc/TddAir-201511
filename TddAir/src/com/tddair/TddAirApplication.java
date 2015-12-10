package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {
  // TO DO: add functionality
	private Map<String, Member> members = new HashMap<>();
	
	public Member registerMember(String username)
	{
		Member member = (Member) members.get(username);
		
		if(member==null)
		{
			member = new Member(username);
			members.put(username, member);
		}
		else
		{
			throw new MemberAlreadyExistsException("Yo, this guy already exists!");
		}
				
		return member;
	}
	
	
	public Member retrieveMember(String username)
	{		
		if(!members.containsKey(username)) throw new IllegalArgumentException();
		
		return members.get(username);		
	}
		
	
	public Member addMiles(String username, int milesToAdd)
	{
		Member member = retrieveMember(username);
		member.setYtdMiles(member.getYtdMiles() + milesToAdd);
		checkAndUpdateStatus(member);
		
		return member;
	}
	
	
	private void checkAndUpdateStatus(Member member)
	{
		int ytdMiles = member.getYtdMiles();
		
		if(ytdMiles < 25001)
		{
			member.setStatus(Status.RED);
		}
		else if(ytdMiles < 50001)
		{
			member.setStatus(Status.GREEN);
		}
		else if(ytdMiles < 75001)
		{
			member.setStatus(Status.BLUE);
		}
		else
		{
			member.setStatus(Status.GOLDEN);
		}
	}
	
	
	public Map getMembers() {
		return members;
	}
	
}
