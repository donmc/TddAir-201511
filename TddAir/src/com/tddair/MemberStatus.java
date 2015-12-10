package com.tddair;

public enum MemberStatus {
	RED(0L, 24999L, 10000, 100),
	GREEN(25000L, 49999L, 9000, 90), 
	BLUE(50000L, 74999L, 8000, 75),
	GOLDEN(75000L, Long.MAX_VALUE, 7000, 60);
	
	public Long startOfRange;
	public Long endOfRange;
	private int upgradeCostMiles;
	private int upgradeCostDollars;
	
	private MemberStatus(Long startOfRange, Long endOfRange, int upgradeCostMiles, int upgradeCostDollars) {
		this.startOfRange = startOfRange;
		this.endOfRange = endOfRange;
		this.upgradeCostMiles = upgradeCostMiles;
		this.upgradeCostDollars = upgradeCostDollars;
	}

	public static MemberStatus valueOf(Long ytdMiles) {
		MemberStatus status = MemberStatus.RED;
		
		for (MemberStatus value : MemberStatus.values()) {
			
			if (isInRangeOfStatus(value, ytdMiles)) {
				status = value;
			}
		}
		
		return status;
	}
	
	private static boolean isInRangeOfStatus(MemberStatus status, Long l) {
		
		return (l >= status.startOfRange && l <= status.endOfRange);
	}

	public long getUpgradeMilesCost() {
		return upgradeCostMiles;
	}
	
	public int getUpgradeDollarsCost(){
		return upgradeCostDollars;
	}

}
