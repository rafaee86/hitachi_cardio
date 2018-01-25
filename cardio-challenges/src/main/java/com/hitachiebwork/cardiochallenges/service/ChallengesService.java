package com.hitachiebwork.cardiochallenges.service;

import java.util.List;
import java.util.Map;

public interface ChallengesService {

	public List<Map<String, Object>> getChallengesBySearchType(String type, Object reference);
	
}
