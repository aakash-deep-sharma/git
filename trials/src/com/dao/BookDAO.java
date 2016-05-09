package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.pojo.Book;

public class BookDAO {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	ArrayList<String> bookNames;
	
	public void addBook()
	{
		
	}

	public void removeBook()
	{
		
	}
	
	public ArrayList<String> searchBook(String bookName)
	{
		try {
				con = MyConnection.connect();
	
				String s = "select name from books where name like '%$bookname";
				String str = s.replace("$bookname", bookName);
				String query = str.concat("%'");
	
				pst = con.prepareStatement(query);
				ResultSet rst = pst.executeQuery();
	
				while (rst.next()) {
					bookNames.add(rst.getString(1));
				}
			}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return bookNames;
	}
	
}
