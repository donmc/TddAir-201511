package com.tddair;

public class Member {

	private String username;
	private MemberStatus status = MemberStatus.RED;
	private Long balance = Long.valueOf(10000); 
	private Long ytdMiles = Long.valueOf(0); 

	public Member(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public Long getBalance() {
		return balance;
	}

	public Long getYTDMiles() {
		return ytdMiles;
	}

}
