package com.tddair;

public enum MemberStatus {
	RED(0L, 24999L),
	GREEN(25000L, 49999L), 
	BLUE(50000L, 74999L),
	GOLDEN(75000L, Long.MAX_VALUE);
	
	public Long startOfRange;
	public Long endOfRange;
	
	private MemberStatus(Long startOfRange, Long endOfRange) {
		this.startOfRange = startOfRange;
		this.endOfRange = endOfRange;
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

}
