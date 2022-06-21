package com.dev.restv1.restapi.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Controller which calls the DAO Service
@RestController
public class UserResource {
	
	//Instance created is now being used here
	@Autowired
	private UserDaoService userDaoService;
	
	//Get All Users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
		
	}
	
	//Get Specific User
	@GetMapping("/users/{id}")
	public User retreiveUser(@PathVariable int id ) {
		return userDaoService.findOne(id);
	}
	
	//Add user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User savedUser=userDaoService.saveUser(user);
		
		//Return Location of the newly created Resoruce
		//Uri of that resource
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(locationUri).build();
	}
	

}
