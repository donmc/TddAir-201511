package com.tddair;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TrackMilesSteps {
	
	private TddAirApplication tddApp;
	private Member member = null;
	private String errorMessage = null;

	public TrackMilesSteps() {
		tddApp = TddAirSingleton.getTddAirAplication();
	}
	
	@Given("^\"([^\"]*)\" member \"([^\"]*)\" with \"(\\d+)\" ytd miles$")
	public void a_status_member_with_ytd_miles(String status, String memberName, int ytdMiles) throws Throwable {
	    this.member = tddApp.registerMember(memberName);
	    tddApp.updateMilesFlown(memberName, ytdMiles);
	}

	@When("^they fly \"(\\d+)\" miles$")
	public void they_fly_miles(int miles) throws Throwable {
	    tddApp.updateMilesFlown(this.member.getUsername(), miles);
	}
}
