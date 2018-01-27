/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.service;

import java.util.List;
import java.util.Map;

public interface ChallengesService {

	public List<Map<String, Object>> getChallengesBySearchType(String type, Object reference);
	
}
