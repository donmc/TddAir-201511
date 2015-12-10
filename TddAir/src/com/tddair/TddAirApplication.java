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
		
		if(ytdMiles < 25000)
		{
			member.setStatus(Status.RED);
		}
		else if(ytdMiles < 50000)
		{
			member.setStatus(Status.GREEN);
		}
		else if(ytdMiles < 75000)
		{
			member.setStatus(Status.BLUE);
		}
		else
		{
			member.setStatus(Status.GOLDEN);
		}
	}
	
	
	public void purchaseUpgradeWithMiles(Member member)
	{
		int balanceMiles = member.getBalanceMiles();		
		Status status = member.getStatus();
		int upgradeCost = upgradeMilesCost(status);
		int upgradedSeat = member.getUpgrade()+1;
		
		if(balanceMiles < upgradeMilesCost(status))
		{
			throw new RuntimeException("you don't have enough coinage");
		}
		else
		{
			member.setBalanceMiles(balanceMiles - upgradeCost);
			member.setUpgrade(upgradedSeat);
		}
	}
	
	
	private int upgradeMilesCost(Status status)
	{
		int upgradeMilesCost = 0;
		
		if(status.equals(Status.RED))
		{
			upgradeMilesCost = 10000;
		} 
		else if(status.equals(Status.GREEN)) 
		{
			upgradeMilesCost = 9000;
		}
		else if(status.equals(Status.BLUE))
		{
			upgradeMilesCost = 8000;
		}
		else
		{
			upgradeMilesCost = 7000;
		}
		
		return upgradeMilesCost;
	}
	
	public void purchaseUpgradeWithDollars(Member member)
	{
		Status status = member.getStatus();
		double balanceAccount = member.getBalanceAccount();		
		double upgradeCost = upgradeDollarsCost(status);
		int upgradedSeat = member.getUpgrade()+1;
		
		if(balanceAccount < upgradeCost)
		{
			throw new RuntimeException("you don't have enough coinage");
		}
		else
		{
			member.setBalanceAccount(balanceAccount - upgradeCost);
			member.setUpgrade(upgradedSeat);
		}
	}
	
	
	private double upgradeDollarsCost(Status status)
	{
		double upgradeDollarsCost = 0.00;
		
		if(status.equals(Status.RED))
		{
			upgradeDollarsCost = 100.00;
		} 
		else if(status.equals(Status.GREEN)) 
		{
			upgradeDollarsCost = 90.00;
		}
		else if(status.equals(Status.BLUE))
		{
			upgradeDollarsCost = 75.00;
		}
		else
		{
			upgradeDollarsCost = 60.00;
		}
		
		return upgradeDollarsCost;
	}
	
	public Map getMembers() {
		return members;
	}
	
}
