package com.tddair;


public class Member {
	private String username;
	private int ytdMiles;
	private int balanceMiles;
	private double balanceAccount = 0.0;
	private Status status;
	private int upgrade;
	private static final int BONUS_MILES = 10000;
	
	public Member(String username) {
		this.username = username;
		this.balanceMiles = BONUS_MILES;
		ytdMiles = 0;
		this.status = Status.RED;
	}

	public String getUsername() {
		return username;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}
	public void setBalanceAccount(double balanceAccount) {
		this.balanceAccount = balanceAccount;
		
	}
	
	public double getBalanceAccount() {
		return balanceAccount;
	}

	public void setYtdMiles(int ytdMiles)
	{
		this.ytdMiles = ytdMiles;
	}

	public int getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(int upgrade) {
		this.upgrade = upgrade;
	}

	public void setBalanceMiles(int balanceMiles) {
		this.balanceMiles = balanceMiles;		
	}

}
