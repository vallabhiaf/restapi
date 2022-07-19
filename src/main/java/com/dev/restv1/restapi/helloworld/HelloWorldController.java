package com.dev.restv1.restapi.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

//Basic Api 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//controller
@RestController
public class HelloWorldController {
	
	//This will automatically connect with messagebudle propertiies and connect with desried input/language
	@Autowired
	private MessageSource messageSource;
	//GET
	//URI - hello-world
	//method -"Hello World"
	// we can also use @GetMapping(path = "/hello-world")
	@RequestMapping(method=RequestMethod.GET,path = "/hello-world")
	public String helloWorld()	{
		return "Hello World";
		
	}
	
	// Send back a Bean(object) now
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World Bean");
	}
	
	// Handle dynamic parameters
	@GetMapping(path = "/hello-world/pathvariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
			return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
	//Locale is prededifned class with references to various languages
	//Ading request paremeter everywhere is cumbersome. We use LocaleContextHolder which automatically picks up required component
	@RequestMapping(method=RequestMethod.GET,path = "/hello-world-internationalized")
	public String helloWorldInternationalized(
			//@RequestHeader(name="Accept-Language",required=false)Locale locale
			)	{
		
		//return "Hello World";
		return messageSource.getMessage("good.morning.message",null,"Default Message",
				//locale);
				LocaleContextHolder.getLocale());
	}
}
