package vn.neways.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import vn.neways.dto.User;
import vn.neways.services.LoginService;

public class LoginAction extends ActionSupport implements Action, ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	
	@Override
    public void validate() {
		System.out.println("validate() is start ...");
		if (StringUtils.isEmpty(user.getUserId())) {
			addFieldError("userId", "userId is not null");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			addFieldError("password", "password is not null");
		}
		System.out.println("validate() is end ...");
    }
	
	public String execute() {
		System.out.println("execute() is start ...");
		LoginService loginService = new LoginService();
		return loginService.auth(user) ? SUCCESS : LOGIN;
	}

	@Override
	public User getModel() {
		return user;
	}

	
}
