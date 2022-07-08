package com.dev.restv1.restapi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Extending default exception handling provided
//caling it a restcontroller as it provides a result back
//Specialization class that needs to shared across multiple controller can use ControllerAdvise
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

}
