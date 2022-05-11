package model.entities;

public class User {
	
	private static User user;
	
	private String userName;
	
	private String password;
	
	
	public static User getInstance() {
		if (user == null) {
			user = new User();
		}
		return user;
	}
	
	
	private User () {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
