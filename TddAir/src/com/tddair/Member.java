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
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getYtdMiles() {
		return ytdMiles;
	}
	
	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
	}
	
	public void updateStatus() {
		if ((balance > 75000)) {
			this.status = Status.GOLD;
		} else if  (balance > 50000) {
			this.status = Status.BLUE;
		} else if (balance > 25000) {
			this.status = Status.GREEN;
		}
		else {
			this.status = Status.RED;
		}
	}
}
