package com.tddair;

public class TddAirSingleton {
	private static TddAirApplication tddAir;
	
	public static TddAirApplication getTddAirAplication() {
		if (tddAir == null) {
			tddAir = new TddAirApplication();
		}
		
		return tddAir;
	}
}
