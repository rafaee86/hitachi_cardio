package com.hitachiebwork.cardiochallenges.service.impl;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitachiebwork.cardiochallenges.repository.ChallengesRepository;
import com.hitachiebwork.cardiochallenges.service.ChallengesService;
import com.hitachiebwork.cardiochallenges.utility.ChallengesSearchType;
import com.hitachiebwork.cardiochallenges.utility.ObjectUtil;
import com.hitachiebwork.cardiochallenges.exception.ChallengesRuntimeException;
import com.hitachiebwork.cardiochallenges.model.ChallengeLevel;
import com.hitachiebwork.cardiochallenges.model.Challenges;

@Service
@Transactional(readOnly = true)
public class ChallengesServiceImpl implements ChallengesService {

	@Autowired
	private ChallengesRepository challengeRepo;
	
	@Override
	public List<Map<String,Object>> getChallengesBySearchType(String type, Object reference) {
		
		List<Challenges> challengesList = null;
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		
		if(type == null || reference == null)
			throw new ChallengesRuntimeException(false, "Search Component Is Undefined", null);
		
		if(ChallengesSearchType.DESCRIPTION.getName().equalsIgnoreCase(type)) {
			if(!ObjectUtil.toString(reference).matches("^[a-zA-Z0-9]*$"))
				throw new ChallengesRuntimeException(false, "Please Send Reference In AlphaNumeric For Type "+type, null);
			challengesList = challengeRepo.findByDescriptionLikeIgnoreCase("%"+ObjectUtil.toString(reference)+"%");
		}else if(ChallengesSearchType.LEVEL.getName().equalsIgnoreCase(type)) {
			if(!ObjectUtil.toString(reference).matches("^[0-9]*$"))
				throw new ChallengesRuntimeException(false, "Please Send Reference In Numeric For Type "+type, null);
			challengesList = challengeRepo.findByLevelPkid(ObjectUtil.toLong(reference));
		}
		
		if(challengesList == null || (challengesList != null && challengesList.isEmpty()))
			throw new ChallengesRuntimeException(false, "Search Result Not Found", null);
		
		if(challengesList != null) {
			ChallengeLevel level = null;
			for(Challenges challenge : challengesList) {
				
				level = challenge.getLevel() != null ? challenge.getLevel() : new ChallengeLevel();
				
				map = new HashMap<String,Object>();
				map.put("pkid", challenge.getPkid());
				map.put("description", challenge.getDescription() != null ? WordUtils.capitalize(challenge.getDescription()) : "");
				map.put("levelDesc", level.getDescription() != null ? WordUtils.capitalize(level.getDescription()) : "");
				map.put("levelCode", level.getCode());
				map.put("calorie", challenge.getCaloriesValue());
				map.put("point", challenge.getPointValue());
				
				mapList.add(map);
			}
		}
		
		return mapList;
		
	}
}
