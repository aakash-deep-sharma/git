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
@WebServlet("/adminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPage() {
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
			
		out.print("<form action='adminFunc' method='get'>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<center>"
				+ "<input type='submit' value='Add Book' name='op' formaction='addBook.html'>"
				+ "<input type='submit' value='Remove Book' name='op' formaction='searchBook.html'>"
				+ "<input type='submit' value='Check User Log' name='op' formaction='getValidUser'>"
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
