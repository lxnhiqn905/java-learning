package vn.neways.dto;

public class User {
	
	private String userId;
	private String userName;
	private String passWord;
	
	public User(String userId, String userName, String passWord) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public String getDisplay() {
		return "User ID is: " + this.userId + " User name is: " + this.userName;
	}
	
	public boolean auth(String pass) {
		return this.passWord.equals(pass);
	}
	
}
