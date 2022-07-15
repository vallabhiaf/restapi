package com.dev.restv1.restapi.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dev.restv1.restapi.user.UserNotFoundException;

//Extending default exception handling provided
//caling it a restcontroller as it provides a result back
//Specialization class that needs to shared across multiple controller can use ControllerAdvise
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	
    // We need to override this method for specific exceptions which was predefined in ResponseEntityExceptionHandler
	
	//Whenever a exception happens this method to be called.
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		//additonal info ( request.getdesxription(false )has to be decided on case by case basis 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);}
		
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		//additonal info ( request.getdesxription(false )has to be decided on case by case basis 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
			
		  return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
		
	
}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		//What has went wrong is stored in the binding results
				ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Validation Error",ex.getBindingResult().toString());
					
				  return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}