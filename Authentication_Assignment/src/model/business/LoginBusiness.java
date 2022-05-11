package model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.User;

public class LoginBusiness {
	
	private static LoginBusiness loginBusiness;
	
	public static LoginBusiness getInstance(){
		if(loginBusiness == null) {
			loginBusiness = new LoginBusiness();
		}
		return loginBusiness;
	}
	
	private LoginBusiness() {
		super();
	}
	
	public boolean validateField(String user, String pass) {
		boolean flag = true;
		if (user.equals("")) {
			flag = false;
		} else if (pass.equals("")) {
			flag = false;
		}
		return flag;
	}
		
	public boolean verifyCredentials(User user) {
		LoginDataAccess lda = LoginDataAccess.getInstance();
		
		try {
			return lda.verifyCredentials(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
