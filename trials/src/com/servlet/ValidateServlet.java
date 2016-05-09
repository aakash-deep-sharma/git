package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.dao.UserDAO;
import com.listeners.SessionCounter;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO user = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String userType = request.getParameter("userType");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pass");
		
		RequestDispatcher rd;
		try
		{
			
		PrintWriter out = response.getWriter();
		
		switch (userType) {
		case "admin":
				if(name.equals("admin") && pwd.equals("admin"))
				{
						rd = request.getRequestDispatcher("adminPage");
						rd.forward(request, response);
				}
				else
				{
					out.print("Invalid password");
					rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
				}
			break;

		default:
			String result = user.validateUser(name, pwd);
			if(result.equals("valid"))
			{
				rd = request.getRequestDispatcher("userPage");
				rd.forward(request, response);
			}
			else
			{
				out.print("Invalid password");
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			break;
		}
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
