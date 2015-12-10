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
		if((balance>0) & (balance<=25000)) {
		this.status = Status.RED;
		}
		else if ((balance>25000)& (balance<=50000)){
			this.status = Status.GREEN;
		}
		else if ((balance>50000)& (balance<=75000)){
			this.status = Status.GOLD;
		}
	}
}
