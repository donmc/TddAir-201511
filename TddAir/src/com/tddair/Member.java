package com.tddair;

public class Member {

	private String username;
	private int ytdMiles;
	private int balanceMiles;
	private Status status;
	private int upgradeCount;
	
	private CreditAuthorizationService cas;
	
	Member(String username) {
		this.username = username;
		this.ytdMiles = 0;
		this.balanceMiles = 10000;
		this.status = Status.RED;
		this.upgradeCount = 0;
	}
	
	public String getUsername() {
		return this.username;
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

	public int getYtdMiles() {
		return this.ytdMiles;
	}

	public void setYtdMiles(int miles) {
		this.ytdMiles = miles;
		
	}
	
	public void addMilesFlown(int miles){
		if(miles < 0) throw new IllegalArgumentException();
		this.ytdMiles += miles;
		this.balanceMiles += miles;
		
		this.status = Status.statusForMiles(this.ytdMiles);
	}

	

	public void purchaseSeatUpgradeWithMiles(int numUpgrades) {
		this.upgradeCount += numUpgrades;
		
		this.balanceMiles -= numUpgrades * this.status.getUpgradeCostMiles();
		
		
	}

	public int getSeatUpgradeCount() {
		return this.upgradeCount;
	}

	public void setCas(CreditAuthorizationService cas) {
		this.cas = cas;		
	}

	public void purchaseSeatUpgradeWithCreditCard(int quantity, String ccNum) {
		if (cas.authorize(status.getUpgradeCostDollars() * quantity, ccNum)) {
			this.upgradeCount += quantity;
		}
	}

}
