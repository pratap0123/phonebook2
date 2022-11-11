package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {
	private static Connection con;
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","root");
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return con;
	}

}
