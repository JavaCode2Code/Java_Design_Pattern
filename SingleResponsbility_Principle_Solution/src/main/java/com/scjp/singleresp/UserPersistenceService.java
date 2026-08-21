package com.scjp.singleresp;
//A separate class for handling persistence 
public class UserPersistenceService {

	private Store store = new Store();
	
	public void saveUser(Users user) {
		store.store(user);
	}
}
