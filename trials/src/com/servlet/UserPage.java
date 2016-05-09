package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/userPage")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
		
			PrintWriter out = response.getWriter();
			
		out.print("<form action='searchBook' method='get'>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<center>"
				+ "<h3 align='center'>To search books, get details of book and add review for a book... Please enter book name:</h3>"
				+ "<input type='text' name='bookName'>"
				+ "<input type='submit' value='Search'>"
				+ "</center>"
				+ "</form>"
				+ "<br>"
				+ "<br>"
				+ "<h3 align='right'><a href='logout.html'>Logout</a></h3>");
		//response.sendRedirect("adminPage.html");
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
