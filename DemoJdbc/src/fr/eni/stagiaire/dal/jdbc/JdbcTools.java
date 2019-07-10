package fr.eni.stagiaire.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.stagiaire.dal.Settings;

public class JdbcTools {
	
	//Attribut
	private static String urldb;
	private static String userdb;
	private static String password;

	// Bloc static qui sera utilisé une fois
	static {
		
		try {
			// Charge le pilote sql jdbc 42
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		password = Settings.getProperty("passworddb");
		
		System.out.println(urldb);
		System.out.println(userdb);
		System.out.println(password);
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(urldb, userdb, password);
	}
	
	public static void closeConnection(Connection connection) throws SQLException
	{
		if(connection != null)
		{
			connection.close();	
		}
	}
	
}
