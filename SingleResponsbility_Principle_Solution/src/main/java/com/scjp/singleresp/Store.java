package com.scjp.singleresp;

import java.util.HashMap;
import java.util.Map;

//Stores data in memory
public class Store {

    private static final Map<String, Users> STORAGE = new HashMap<>();

    public void store(Users user) {
        synchronized(STORAGE) {
            STORAGE.put(user.getName(), user);
        }
    }

    public Users getUser(String name) {
        synchronized(STORAGE) {
            return STORAGE.get(name);
        }
    }
}