/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.utility;

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
