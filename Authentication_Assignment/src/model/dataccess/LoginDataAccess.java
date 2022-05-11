package model.dataccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {
	
	private static LoginDataAccess loginDataAccess;
	
	public static LoginDataAccess getInstance() {
		
		if(loginDataAccess == null) {
			loginDataAccess = new LoginDataAccess();
		}
		
		return loginDataAccess;
	}
	
	private LoginDataAccess() {
		super();
	}

	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {

		Connection conection = ConnectionFactory.getConnection();

		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}

}

