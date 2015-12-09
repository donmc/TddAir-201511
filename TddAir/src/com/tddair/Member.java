package com.tddair;

public class Member {
	
	private String username;
	private String status;
	private int balance;
	private int ytdMiles;

	public Member(String username) {
		this.username = username;
		this.status = "RED";
		this.balance = 10000;
		this.ytdMiles = 0;
	}

	public String getUsername() {
		return username;
	}

	public String getStatus() {
		return status;
	}

	public int getBalance() {
		return balance;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}
}
