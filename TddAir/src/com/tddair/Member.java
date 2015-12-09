package com.tddair;

public class Member {
	
	private String username;
	private String status;
	private int balance;

	public Member(String username) {
		this.username = username;
		this.status = "RED";
		this.balance = 10000;
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
}
