/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.service.impl;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitachiebworx.cardiochallenges.exception.ChallengesRuntimeException;
import com.hitachiebworx.cardiochallenges.model.ChallengeLevel;
import com.hitachiebworx.cardiochallenges.model.Challenges;
import com.hitachiebworx.cardiochallenges.repository.ChallengesRepository;
import com.hitachiebworx.cardiochallenges.service.ChallengesService;
import com.hitachiebworx.cardiochallenges.utility.ChallengesSearchType;
import com.hitachiebworx.cardiochallenges.utility.ObjectUtil;

@Service
@Transactional(readOnly = true)
public class ChallengesServiceImpl implements ChallengesService {

	@Autowired
	private ChallengesRepository challengeRepo;
	
//	This method only accept :
//		- Type = Description --> Only accept reference in alphanumeric
//		- Type = Level --> Only accept in numeric
//		- Key null and Result null will produce Exception 
	
	@Override
	public List<Map<String,Object>> getChallengesBySearchType(String type, Object reference) {
		
		List<Challenges> challengesList = null;
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		
		if(!ObjectUtil.notNull(type) || !ObjectUtil.notNull(reference))
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
