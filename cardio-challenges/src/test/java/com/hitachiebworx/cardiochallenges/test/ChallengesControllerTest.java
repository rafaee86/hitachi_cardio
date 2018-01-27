package com.hitachiebworx.cardiochallenges.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hitachiebworx.cardiochallenges.Application;
import com.hitachiebworx.cardiochallenges.exception.ChallengesRuntimeException;
import com.hitachiebworx.cardiochallenges.service.ChallengesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class })
public class ChallengesControllerTest {

    @Autowired
    private ChallengesService service;

    @Test(expected = ChallengesRuntimeException.class)
    public void testCaughtByChallengeExceptionByNullInput() throws Exception {
    	
        service.getChallengesBySearchType(null, null);
    }
    
    @Test(expected = ChallengesRuntimeException.class)
    public void testCaughtByChallengeExceptionByUnintendedValue() throws Exception {
    	
        service.getChallengesBySearchType("!", "#@");
    }
    
    @Test(expected = ChallengesRuntimeException.class)
    public void testWithTypeLevelWithFalseValue() throws Exception {    	
    	service.getChallengesBySearchType("Level", "100");    
    }
    
    @Test(expected = ChallengesRuntimeException.class)
    public void testWithTypeDescriptionWithFalseValue() throws Exception {
    	service.getChallengesBySearchType("Description", "XXX");    	
    }
    
    @Test
    public void testWithTypeLevelWithTrueValue() throws Exception {    	
    	List<Map<String,Object>> list = service.getChallengesBySearchType("Level", "1");    	
        assertTrue(list != null && list.size() > 0);
    }
    
    @Test
    public void testWithTypeDescriptionWithTrueValue() throws Exception {
    	List<Map<String,Object>> list = service.getChallengesBySearchType("Description", "Jog");    	
        assertTrue(list != null && list.size() > 0);
    }

}
