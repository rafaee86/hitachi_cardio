package com.hitachiebwork.cardiochallenges.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hitachiebwork.cardiochallenges.exception.ChallengesRuntimeException;
import com.hitachiebwork.cardiochallenges.exception.ErrorForm;

public abstract class MainAbstractController {

	protected static Logger logger = LoggerFactory.getLogger(MainAbstractController.class);

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(ChallengesRuntimeException.class)
	@ResponseBody
	public ErrorForm handleException(ChallengesRuntimeException e) {
		return new ErrorForm(e);
	}
}
