package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ApplJDBC {
	private static Connection con = null;
//	private static String username = "ssu-oms";
//	private static String password = "ssu-oms";
//	private static String username = "067db";
//	private static String password = "067db";
	// private static String username = "db304";
	// private static String password = "db304";
	//private static String username = "root";
	//private static String password = "root";
//	private static String username = "lv448";
//	private static String password = "Pa$$Lv448";
	// private static String username = "postgres";
	// private static String password = "postgres";
	//private static String username = "lv3X4";
	//private static String password = "Lv3X4_TAQC";
	private static String username = "lv459";
	private static String password = "Lv459_Taqc";
	//
	// Microsoft
	// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS";
	// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv304test;";
	//// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;";
	//// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv215Test;";
	// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv196first;";
	// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=Lv169OMS;";
	// private static String URL ="jdbc:sqlserver://ssu-sql12\\tc;databasename=ssu-oms;";
	//private static String URL ="jdbc:sqlserver://ssu-oms\\SQLEXPRESS;databasename=_067_OMS1"; // 192.168.195.239
	//
	// Sybase
	//// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/lv304test;instance=SQLEXPRESS;";
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/lv257Test;instance=SQLEXPRESS;";
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/lv235Test;instance=SQLEXPRESS;";
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/lv215Test;instance=SQLEXPRESS;";
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02;instance=SQLEXPRESS;";
	//// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/lv196first;instance=SQLEXPRESS;";
	//private static String URL =
	//		"jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;"; // port=1433
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/Lv169OMS;instance=SQLEXPRESS;";
//	private static String URL ="jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
//	private static String URL ="jdbc:jtds:sqlserver://ssu-oms/_067_OMS1;instance=SQLEXPRESS;"; // 192.168.195.239
	//
	// MySQL
	//private static String URL = "jdbc:mysql://localhost:3306/lv326";
	//private static String URL = "jdbc:mysql://localhost:3306/lv304test";
	// private static String URL = "jdbc:mysql://localhost:3306/lv257Test";
	// private static String URL = "jdbc:mysql://localhost:3306/lv235Test";
	// private static String URL = "jdbc:mysql://localhost:3306/lv215Test";
	// private static String URL =
	// "jdbc:mysql://localhost:3306/measurement_devices";
	// private static String URL = "jdbc:mysql://localhost:3306/registrator_db";
	//// private static String URL = "jdbc:mysql://localhost:3306/lv196first";
	////private static String URL = "jdbc:mysql://localhost:3306";
	//private static String URL = "jdbc:mysql://localhost:3306/lv344";
	//private static String URL = "jdbc:mysql://192.168.103.191:3306/opencart";
	//private static String URL = "jdbc:mysql://localhost:3306/lv344";
	//private static String URL = "jdbc:mysql://localhost:3306/lv375work";
	//private static String URL = "jdbc:mysql://localhost:3306";
//	private static String URL = "jdbc:mysql://localhost:3306/lv448work";
	private static String URL = "jdbc:mysql://10.26.34.177:3306/opencart";
	//
	// PostgresSQL
	// private static String URL =
	// "jdbc:postgresql://192.168.195.250:5432/registrator_db";

	public static void main(String[] args) throws Exception {
		System.out.println("Start...");
		// Microsoft
//		DriverManager.registerDriver(new
//				 com.microsoft.sqlserver.jdbc.SQLServerDriver());
//		DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
		//
		// DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
		// Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//
		////DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Class.forName("com.mysql.jdbc.Driver");
		//
		// DriverManager.registerDriver(new org.postgresql.Driver());
		//
		// Load the driver
		con = DriverManager.getConnection(URL, username, password);
		if (con != null) {
			System.out.println("Connection Successful! \n");
		} else {
			System.out.println("Connection ERROR \n");
			System.exit(1);
		}
		Statement st = con.createStatement();
		// Statement allows you to send inquiries database
		// ResultSet rs = st.executeQuery("select * from TUser");
		// ResultSet rs = st.executeQuery("select * from Users");
		// ResultSet rs = st.executeQuery("SELECT ID, Login, Password,
		// FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE
		// Login = 'aaai';");
		// ResultSet rs = st.executeQuery("SELECT * FROM dbo.Users;");
		//
		////st.execute("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef, IsUserActive) VALUES ('iva222','qwerty', 'ivanka', 'horoshko', 'mail@gmail.com', '1', '1', '1');");
		////st.execute("DELETE Users WHERE Login='iva';");
		////ResultSet rs = st.executeQuery("SELECT * FROM users WHERE Login='iva';");
//		ResultSet rs = st.executeQuery("SELECT * FROM users WHERE Login LIKE 'iv%';");
//		ResultSet rs = st.executeQuery("SELECT * FROM Users;");
		// ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE Login LIKE
		// 'iv%';");
		// MySQL
		// ResultSet rs = st.executeQuery("SELECT * FROM User;");
		// st.execute("INSERT INTO user
		// (username,isAvailable,password,firstName,lastName,organizationId)
		// VALUES
		// ('verificator-lv2',1,'$2a$10$59Mv7tEUrVH8iBeDsm9y7.zUcJoPHnnyOvMnC4zKRV8.wlnugQ2G2','first-lv2','last-lv2',7);");
		// st.execute("INSERT INTO user_role (username,value) VALUES
		// ('verificator-lv2','STATE_VERIFICATOR_ADMIN');");
		// st.execute("INSERT INTO users (name,age) VALUES ('stepan',123);");
		//
		// ResultSet rs = st.executeQuery("SELECT * FROM User WHERE username
		// LIKE 'verifi%';");
		// ResultSet gets the result table
		//
		// st.execute("INSERT INTO TUser (name,age) VALUES ('Taras','22');");
		// ResultSet rs = st.executeQuery("select * from TUser");
		//// st.execute("INSERT INTO Empl (name,email) VALUES
		// ('Tolik','tol@yahhoo.com');");
		//// st.execute("INSERT INTO Empl (name,email) VALUES
		// ('Taras','tar@mail.com');");
		// st.execute("DELETE Empl WHERE name='Tolik';");
		//// st.execute("UPDATE Empl SET name='SuperTaras' WHERE name LIKE
		// 'Tar%';");
		//
//		st.execute("CREATE DATABASE lv448work;");
//		st.execute("USE lv448work;");
//		st.execute("CREATE SCHEMA `lv448work` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;");
//		st.execute("Use lv375work;");
//		st.execute("CREATE TABLE MyUsers ("
//				+" `id` INT NOT NULL AUTO_INCREMENT,"
//				+ " `Name` VARCHAR(45) NOT NULL,"
//				+ " PRIMARY KEY (`id`),"
//				+ "  UNIQUE INDEX `id_UNIQUE` (`id` ASC));");
//		st.execute("INSERT INTO MyUsers (Name) VALUES ('Ivan');");
//		st.execute("INSERT INTO MyUsers (Name) VALUES ('Petro');");
//		st.execute("INSERT INTO MyUsers (Name) VALUES ('Taras');");
//		st.execute("UPDATE MyUsers SET Name='SuperVasja' WHERE Name LIKE 'Vas%';");
//		st.execute("DELETE FROM MyUsers WHERE id=5;");
		//
		// st.execute("INSERT INTO Users
		// (firstname,lastname,login,password,email) VALUES
		// ('Taras','Tarasov','tara','qwerty3','a@i.ua');");
		// st.execute("UPDATE Users SET firstname='SuperTaras' WHERE lastname LIKE
		// 'Tar%';");
		// st.execute("DELETE Users WHERE firstname='SuperTaras';");
		//// st.execute("UPDATE peoples SET name='SuperIvan' WHERE name LIKE 'Iv%';");
		//
		// st.execute("DELETE FROM MyUsers WHERE name='Vasja';");
		// st.execute("DELETE FROM peoples WHERE name='Petro2';");
		//
		// st.execute("CREATE DATABASE lv257work;");
		//// st.execute("use lv257work;");
		// st.execute("CREATE TABLE MyUsers (Id INT IDENTITY NOT NULL PRIMARY
		// KEY, FirstName VARCHAR(20) NOT NULL, Mail VARCHAR(20) NOT NULL, Class
		// INT NOT NULL);");
		//// st.execute("INSERT INTO MyUsers (FirstName,Mail,Class) VALUES
		// ('Taras2','a@i.ua','11');");
		//// st.execute("INSERT INTO MyUsers (FirstName,Mail,Class) VALUES
		// ('Petro2','p@i.ua','12');");
		//// st.execute("INSERT INTO peoples (name) VALUES ('Petro2');");
		//
		//st.execute("INSERT INTO students (name) VALUES ('Petro2');");
		//st.execute("UPDATE students SET name='SuperPetro' WHERE name LIKE 'Pet%';");
		//st.execute("DELETE FROM students WHERE id=4;");
		//ResultSet rs = st.executeQuery("select * from students;");
		//
		//ResultSet rs = st.executeQuery("select * from peoples;");
		//ResultSet rs = st.executeQuery("select * from Users;");
		//
		//st.execute("select * from Users;");
		//
		//st.execute("INSERT INTO temp (name,login,password,age) VALUES ('Mykola','Myk','qwerty',25);");
		//st.execute("DELETE FROM temp WHERE name='Petro';");
		//st.execute("UPDATE temp SET name='SuperPetro' WHERE name LIKE 'Pet%';");
		//st.execute("select * from temp;");
		//
        //st.execute("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef, IsUserActive) VALUES ('temp', 'qwerty', 'ivatemp', 'horoshkotemp', 'temp@gmail.com', '1', '1', '1');");
        //st.execute("select * from Users;");
		//ResultSet rs = st.getResultSet();
		//
		//st.execute("UPDATE oc_customer_login SET total='1' WHERE email LIKE 'abc%';");
		ResultSet rs = st.executeQuery("select * from oc_customer_login;");
//		ResultSet rs = st.executeQuery("select * from MyUsers;");
		//
		//ResultSet rs = st.getResultSet();
		//
		// ResultSet rs = st.executeQuery("select user_id, email, first_name,
		// login, password from Users;");
		//
		int columnCount = rs.getMetaData().getColumnCount();
		// Resultset.getMetaData () get the information
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");
		}
		System.out.println();
		// output file
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		System.out.println("before close");
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		System.out.println("DONE");
	}

}
