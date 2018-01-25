package com.hitachiebwork.cardiochallenges.exception;

import java.util.Map;

public class ChallengesRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private Boolean status;
	private String customMessage;
	private Map<String, Object> misc;

	public ChallengesRuntimeException(Boolean status, String customMessage, Map<String, Object> misc) {
		this.status = status;
		this.customMessage = customMessage;
		this.misc = misc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public Map<String, Object> getMisc() {
		return misc;
	}

	public void setMisc(Map<String, Object> misc) {
		this.misc = misc;
	}

}
