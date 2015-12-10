package com.tddair;

public class SpyCreditAuthorizationService implements CreditAuthorizationService {

	public static final String GOOD_CC = "1111111111111111";
	public static final String BAD_CC = "999999999999";
	
	int amountCharged;
	
	@Override
	public boolean authorize(int amount, String ccNumber) {
		this.amountCharged = amount;
		
		return ccNumber.equals(GOOD_CC);
	}
	
	public int getAmountCharged() {
		return this.amountCharged;
	}
}
