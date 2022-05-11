package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		final String url = "jdbc:postgresql://localhost:5433/Homework";

		final String user = "postgres";

		final String pass = "123";
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		Class.forName("org.postgresql.Driver");
		
		return connection;
	}
}
