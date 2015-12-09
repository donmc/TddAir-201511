package com.tddair;

public class Member {
	
	private static final int BONUS_MILES = 10000;
	private String username;
	private Status status;
	private int balance;
	private int ytdMiles;

	public Member(String username) {
		this.username = username;
		this.status = Status.RED;
		this.balance = BONUS_MILES;
		this.ytdMiles = 0;
	}

	public String getUsername() {
		return username;
	}

	public Status getStatus() {
		return status;
	}

	public int getBalance() {
		return balance;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}
}
