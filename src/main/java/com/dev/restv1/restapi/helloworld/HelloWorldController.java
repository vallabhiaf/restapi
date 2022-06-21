package com.dev.restv1.restapi.helloworld;

//Basic Api 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//controller
@RestController
public class HelloWorldController {
	
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

}
