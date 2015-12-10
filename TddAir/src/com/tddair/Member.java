package com.tddair;

public class Member {

	private String username;
	private MemberStatus status = MemberStatus.RED;
	private Long balance = Long.valueOf(10000); 
	private Long ytdMiles = Long.valueOf(0);
	private int seatUpgrades = 0;
	private CreditAuthorizationService cas; 

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

	public void setBalance(long balanceMiles) {
		this.balance = balanceMiles;
	}

	public void setYTDMiles(long ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public void addMiles(long l) {
		this.balance += l;
		this.ytdMiles += l;
		
		this.status = MemberStatus.valueOf(this.ytdMiles);
	}

	public int getUpgrades() {
		return seatUpgrades ;
	}

	public void purchaseUpgradeByMiles(int numberOfUpgrades) throws UpgradeException {
		
		if (this.balance >= status.getUpgradeMilesCost()*numberOfUpgrades) {
			
			this.seatUpgrades += numberOfUpgrades;
			this.balance -= status.getUpgradeMilesCost()*numberOfUpgrades;
		} else {
			throw new UpgradeException("Not enough balance");
		}
	}

	public void setCas(CreditAuthorizationService cas) {
		this.cas = cas;
	}

	public void purchaseUpgradeByPayment(int numberOfUpgrades, String creditCard) {
		int amount = status.getUpgradeDollarsCost() * numberOfUpgrades;
		boolean isValid = cas.authorize(amount, creditCard);
		if(isValid){
			this.seatUpgrades += numberOfUpgrades;
		}
	}

}
