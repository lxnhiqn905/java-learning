package vn.neways.service;

import java.util.HashMap;

import vn.neways.dto.User;

public class LoginService {

	HashMap<String, User> userMap = new HashMap<>();
	// User mock
	public LoginService() {
		for (int i = 0; i < 10; i++) {
			userMap.put("user" + String.valueOf(i),
					new User("user" + String.valueOf(i), "name" + String.valueOf(i), "pass" + String.valueOf(i)));
		}

	}

	// When user equals pass then return true
	public boolean authencation(String user, String pass) {
		return userMap.containsKey(user) && userMap.get(user).auth(pass);
	}
	
	// When user equals pass then return true
	public User getUser(String user) {
		return userMap.get(user);
	}
}
