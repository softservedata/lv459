package com.softserve.edu.opencart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.softserve.edu.opencart.data.IUser;

public final class DataBaseUtils {

	private static final String DATABASE_SERVER_IP = "10.26.34.177";
	private static final String DATABASE_URL = "jdbc:mysql://" + DATABASE_SERVER_IP
			+ "/opencart?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	private static final String USERNAME = "lv459";
	private static final String PASSWORD = "Lv459_Taqc"; // TODO remove
	//
	private static final String SET_LOGINED_USERS_TO_NULL = "TRUNCATE opencart.oc_customer_login;";
	//private static final String SELECT_LOGINED_USERS = "SELECT * FROM opencart.oc_customer_login WHERE email LIKE ?;";
	private static final String CLEAR_LOGINED_USERS = "DELETE FROM opencart.oc_customer_login WHERE email LIKE '%s';";
	//
	private static Connection connection;

	private DataBaseUtils() {
	}

	public static void openConnection() {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			System.out.println(e.getMessage());
			throw new RuntimeException("Connection Error");
		}
	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			e.printStackTrace();
		}
	}

	public static void setLoginedUsersToNull() {
		if (connection == null) {
			openConnection();
		}
		try (PreparedStatement ps = connection.prepareStatement(SET_LOGINED_USERS_TO_NULL)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			System.out.println(e.getMessage());
		} 
//		finally {
//			closeConnection();
//		}
	}

	public static void clearLoginedUsers(IUser user) {
		if (connection == null) {
			openConnection();
		}
		System.out.println("***clearLoginedUsers: " + user);
		try (Statement st = connection.createStatement()) {
			String sqlRequest = String.format(CLEAR_LOGINED_USERS, user.getEmail());
			System.out.println("***sqlRequest: " + sqlRequest);
			st.execute(sqlRequest);
			//st.execute(String.format(CLEAR_LOGINED_USERS, user.getEmail()));
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			System.out.println(e.getMessage());
		}
//		finally {
//			closeConnection();
//		}
	}

}
