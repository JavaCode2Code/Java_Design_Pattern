package com.scjp.singleresp;
import java.io.IOException;

public class Main {

	private static final String VALID_USER_JSON = "{\"name\": \"Sateesh122@\", \"email\": \"skm@email.com\", \"address\":\"110 new jersy lane\"}";
	
	private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";

	public static void main(String[] args) throws IOException {
		UserController controller = new UserController();
		
		String response = controller.createUser(VALID_USER_JSON);	
		if(!response.equalsIgnoreCase("SUCCESS")) {
			System.err.println("Failed");
		}
		System.out.println("Valid JSON received response: "+response);
		response = controller.createUser(INVALID_USER_JSON);
		if(!response.equalsIgnoreCase("ERROR")) {
			System.err.println("Failed");
		}
		System.out.println("Invalid JSON received response: "+response);
	}

}
