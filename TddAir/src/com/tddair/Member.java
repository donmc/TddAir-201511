package com.tddair;


public class Member {
	private String username;
	private int ytdMiles;
	private int balanceMiles;
	private Status status;
	private final int Bonus_miles = 10000;
	
	public Member(String username) {
		this.username = username;
		this.balanceMiles = Bonus_miles;
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

	public void setYtdMiles(int ytdMiles)
	{
		this.ytdMiles = ytdMiles;
	}
}
