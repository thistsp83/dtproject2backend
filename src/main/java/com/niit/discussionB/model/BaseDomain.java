package com.niit.discussionB.model;

import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient
	public String errorCode;
	@Transient
	public String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
