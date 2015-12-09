package com.tddair;

public class Member {
	
	private String username;
	private String status;

	public Member(String username) {
		this.username = username;
		this.status = "RED";
	}

	public String getUsername() {
		return username;
	}

	public String getStatus() {
		return status;
	}
}
