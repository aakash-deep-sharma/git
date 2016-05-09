package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;

public class MyConnection {
	
	//STATIC METHOD TO RETURN OBJECT OF CONNECTION
	public static Connection connect() throws Exception {
		Connection con;
		
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/book", "root", "root");

		return con;

	}
}
