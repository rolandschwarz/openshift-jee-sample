package com.myservice.ws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class UsersGetter {
	
	private static final Logger log = Logger.getLogger(UsersGetter.class.getName());

	public static User getUser() {
		
		User user = null;
		try {
			String databaseURL = "jdbc:postgresql://";
			databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
			databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
			String username = System.getenv("POSTGRESQL_USER");
			String password = System.getenv("PGPASSWORD");
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb?currentSchema=testdb&user=postgres&password=postgres");
			if (connection != null) {
				log.info("got connection retrieve data from database...");
				String SQL = "select * from users";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				user = new User();
				while (rs.next()) {
					user.setFirstName(rs.getString("firstname"));
					user.setLastName(rs.getString("lastname"));
				}
				log.info("age of current user: "+user.getAge());
				rs.close();
				connection.close();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return user;
	}
	
}
