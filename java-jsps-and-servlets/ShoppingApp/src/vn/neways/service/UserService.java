package vn.neways.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import vn.neways.dto.User;
import vn.neways.enums.Enums;

public class UserService {
    
    public boolean login(HttpServletRequest request) {
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	
	HashMap<String, User> userMap = getUserMap(request);
	if (userMap == null) {
	    return false;
	}
	if (userMap.containsKey(user) && userMap.get(user).auth(pass)) {
	    request.getSession().setAttribute(Enums.USER_LOGIN.toString(), user);
	    return true;
	}
	return false;
    }
    
    public boolean signup(HttpServletRequest request) {
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	
	HashMap<String, User> userMap = getUserMap(request);
	if (userMap == null) {
	    userMap = new HashMap<String, User>();
	}
	if (userMap.containsKey(user)) {
	    return false;
	}	
	userMap.put(user, new User(user, pass));
	request.getServletContext().setAttribute(Enums.USER_MAP.toString(), userMap);
	return true;
    }
    
    public HashMap<String, User> getUserMap(HttpServletRequest request) {
	return (HashMap<String, User>) request.getServletContext().getAttribute(Enums.USER_MAP.toString());
    }
    
    public String getUserLogin(HttpServletRequest request) {
	return (String) request.getSession().getAttribute(Enums.USER_LOGIN.toString());
    }
}
