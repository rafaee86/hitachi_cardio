/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.exception;

import java.util.Map;

public class ErrorForm {

	private String status;
	private String message;
	private Map<String, Object> misc;

	public ErrorForm(ChallengesRuntimeException e) {
		if (e != null) {
			this.status = e != null && e.getStatus() != null ? e.getStatus().toString() : null;
			this.message = e.getCustomMessage();
			this.misc = e.getMisc();
		}
	}

	public ErrorForm(Boolean status, String message, Map<String, Object> misc) {
		this.status = status != null ? status.toString() : null;
		this.message = message;
		this.misc = misc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status != null ? status.toString() : null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getMisc() {
		return misc;
	}

	public void setMisc(Map<String, Object> misc) {
		this.misc = misc;
	}

}
