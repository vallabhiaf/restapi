package com.dev.restv1.restapi.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Controller which calls the DAO Service(can also be named UserController)
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
	public EntityModel<User> retreiveUser(@PathVariable int id ) {
		User user = userDaoService.findOne(id);
		if (user ==null)
			throw new UserNotFoundException("id-"+id);
		//Converted into to entity model to add links/hateoas(actions/other resources)
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers =linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
		
	}
	
	//Add user
	//Validation by predefined java validation APi
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User user)
	{
		User savedUser=userDaoService.saveUser(user);
		
		//Return Location of the newly created Resoruce
		//Uri of that resource
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(locationUri).build();
	}
	
	//Delete a User
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = userDaoService.deleteById(id);
		
	    if(user == null) {
	    	throw new UserNotFoundException("id="+id);
	    	
	    }
		
	}

}
