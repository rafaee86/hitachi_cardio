/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hitachiebworx.cardiochallenges.exception.ChallengesRuntimeException;
import com.hitachiebworx.cardiochallenges.service.ChallengesService;

@Controller
@RequestMapping("/view/challenge")
public class ChallengesController extends MainAbstractController {

	@Autowired
	private ChallengesService challengesService;
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String,Object>> getChallengesBySearchType(
		@RequestBody Map<String,String> json	
	){
		if(json == null)
			throw new ChallengesRuntimeException(false, "JSON Input not found", null);
		
		String type = json.get("type");
		String reference = json.get("reference");
		
		return challengesService.getChallengesBySearchType(type, reference);
	}
}
