package com.dev.restv1.restapi.exception;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

//This class is to set a standard for returning responses when an exception occurs
public class ExceptionResponse {
   private Date timeStamp;
   private String message;
   private String details;
   
public ExceptionResponse(Date timeStamp, String message, String details) {
	
	super();
	this.timeStamp = timeStamp;
	this.message = message;
	this.details = details;
}

public Date getTimeStamp() {
	return timeStamp;
}

public String getMessage() {
	return message;
}

public String getDetails() {
	return details;
}

   
   
}
