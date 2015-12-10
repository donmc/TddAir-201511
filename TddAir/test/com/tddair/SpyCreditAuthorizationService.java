package com.tddair;

public class SpyCreditAuthorizationService implements CreditAuthorizationService {
	
	static final String GOOD_CC = "1234567812345678";
	static final String BAD_CC = "9999999999999999";
	private int amount;
	
	@Override
	public boolean authorize(int amount, String ccNum){
		this.amount = amount;
		boolean isValid = false;
		if(ccNum == GOOD_CC){
			isValid = true;
		}
		return isValid;
	}

	public Object getAmountCharged() {
		return amount;
	}

}
