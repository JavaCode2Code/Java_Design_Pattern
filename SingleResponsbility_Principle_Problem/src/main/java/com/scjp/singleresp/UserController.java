package com.scjp.singleresp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
//Handles incoming JSON requests that work on User resource/entity
public class UserController {

	private Store store=new Store();
	
	public String createUser(String validUserJson) throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper= new ObjectMapper();
		Users users=mapper.readValue(validUserJson, Users.class);
		if(!isValidUser(users)) {
			return "Error";
		}
		store.store(users);
		return "Success";
	}

	private boolean isValidUser(Users users) {
		// TODO Auto-generated method stub
		if(!isPresent(users.getName())) {
			return false;
		}
		users.setName(users.getName().trim());
		if(!isValidAlphaNumeric(users.getName())) {
			return false;
		}
		if(users.getEmail()==null||users.getEmail().trim().length()==0) {
			return false;
		}
		users.setEmail(users.getEmail().trim());
		if(!isValidEmail(users.getEmail())) {
			return false;
		}
		return true;
	}

	private boolean isValidEmail(String value) {
		// TODO Auto-generated method stub
		 Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); 
	        Matcher matcher = pattern.matcher(value);
	        return matcher.find();
	}

	private boolean isValidAlphaNumeric(String value) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]"); 
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
	}

	private boolean isPresent(String string) {
		// TODO Auto-generated method stub
		return string != null && string.trim().length() > 0;
	}

}
