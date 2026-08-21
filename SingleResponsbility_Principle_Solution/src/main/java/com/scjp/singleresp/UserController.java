package com.scjp.singleresp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
//Handles incoming JSON requests that work on User resource/entity
public class UserController {

	
	public String createUser(String validUserJson) throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper= new ObjectMapper();
		Users users=mapper.readValue(validUserJson, Users.class);
		UserValidator userValidator=new UserValidator();
		userValidator.validateUser(users);
	UserPersistenceService userPersistenceService=new UserPersistenceService();
	
	userPersistenceService.saveUser(users);
		return "Success";
	}

}
