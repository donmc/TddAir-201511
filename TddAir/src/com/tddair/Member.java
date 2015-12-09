package com.tddair;

public class Member {

	private String username;
	private int ytdMiles;
	private int balanceMiles;
	private Status status;
	
	Member(String username) {
		this.username = username;
		this.ytdMiles = 0;
		this.balanceMiles = 0;
	}
	
	public String getUsername() {
		return this.username;
	}

	public int getYTDMiles() {
		return this.ytdMiles;
	}

	public int getBalanceMiles() {
		return this.balanceMiles;
	}

	public void setBalanceMiles(int miles) {
		this.balanceMiles = miles;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
