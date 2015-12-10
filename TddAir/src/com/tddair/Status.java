package com.tddair;

public enum Status {
	RED(0,10000,100), GREEN(25000, 9000, 90), BLUE(50000, 8000, 75), GOLD(75000, 7000, 60);
	
	private int milesTheshold;
	private int upgradeCostMiles;
	private int upgradeCostDollars;
	

	private Status(int milesThreshold, int upgradeCostMiles, int upgradeCostDollars){
		this.milesTheshold = milesThreshold;
		this.upgradeCostMiles = upgradeCostMiles;
		this.upgradeCostDollars = upgradeCostDollars;
		
	} 
	
	public int getMilesThreshold(){
		return this.milesTheshold;
	}
	
	public int getUpgradeCostMiles() {
		return this.upgradeCostMiles;
	}
	
	public int getUpgradeCostDollars(){
		return this.upgradeCostDollars;
	}
	
	public static Status statusForMiles(int miles) {
		Status status = Status.RED;
		if(miles >= BLUE.getMilesThreshold()) {
			status = Status.BLUE;
		}
		else if(miles >= GREEN.getMilesThreshold()){
			status = Status.GREEN;
		}
		else if(miles >= GOLD.getMilesThreshold()){
			status = Status.GOLD;
		}
		return status;
	}
}
