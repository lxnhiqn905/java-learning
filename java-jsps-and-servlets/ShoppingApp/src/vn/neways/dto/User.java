package vn.neways.dto;

public class User {

    private String user;
    private String pass;
    
    public User(String user, String pass) {
	this.user = user;
	this.pass = pass;
    }
    
    public boolean auth(String pass) {
	return this.pass.equals(pass);
    }
}
