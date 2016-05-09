package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int counter = 0;
		counter++;
		String c = Integer.toString(counter);
		Cookie visitors = new Cookie("visitorCount", c);
		response.setContentType("text/html");
		response.addCookie(visitors);
		Cookie[] c1 = request.getCookies();

		PrintWriter out = response.getWriter();

		String doc = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset='ISO-8859-1'>"
				+ "<title>Insert title here</title>" + "</head>" + "<body>" + "<form action='userFunc' method='post'>"
				+ "<input type='submit' value='Search Book' name='op'>" + "</form>" + "<br>" + "<br>"
				+ "<a href='logout.html'>Click to logout...</a>" + "</body>" + "</html>";

		out.print("hits :" + c1.length);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
