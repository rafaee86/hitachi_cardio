package com.hitachiebwork.cardiochallenges.utility;

public enum ChallengesSearchType {
	DESCRIPTION("DESCRIPTION"),
	LEVEL("LEVEL");
	
	private String name;
	
	private ChallengesSearchType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
