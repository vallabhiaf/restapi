
// This service will talk to the DB in repect to  User Bean
package com.dev.restv1.restapi.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
// Component so that Spring boot can manger it by creating a bean instance
@Component
public class UserDaoService {
	
	//
	private static List<User> users = new ArrayList<>();
	private static int usersCount =3;
	
	
	static
	{   //Adding some static Users before hand
		//add is a method of List DS and new object of User Type is being created 
		users.add(new User(1,"Vallabh",new Date()));
		users.add(new User(2,"Ram",new Date()));
		users.add(new User(3,"Ratan",new Date()));
	}
	
	//Return list of all users from Db
	
	public List<User> findAll(){
		return users;
	}
	
	//saving a user with custom id numer
	public User saveUser(User user)
	{   if (user.getId() == null) {
		    user.setId(++usersCount);
	}
          users.add(user);
          return user;          
	}
    
	//retireving a user based on id passed 
	public User findOne(int id)
	{
		for (User user:users)
		{
			if (id == user.getId())
			{
				return user;
				
			}
		}
		return null;
		}
	
		
	}

