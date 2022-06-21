package com.dev.restv1.restapi.helloworld;

public class HelloWorldBean {
      private String message;
      
      HelloWorldBean(String message) {
		  
		  this.message=message;
		  
		// TODO Auto-generated constructor stub
	} 
      
      public void setMessage(String message) {
  		this.message = message;
  	}
      

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	

	
	

}
