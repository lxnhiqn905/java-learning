package vn.neways.services;

import vn.neways.dto.User;

public class LoginService {
	
	public boolean auth(User user) {
		return user.auth();
	}
	
}
