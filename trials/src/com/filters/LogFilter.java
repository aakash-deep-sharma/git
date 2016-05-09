package com.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/logFilter")
public class LogFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LogFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
//		Connection conn = null;
//		ResultSet rs;
//		PreparedStatement pst = null;
//		PrintWriter out = response.getWriter();
//		response.setContentType("html/text");
		
		String userName = request.getParameter("uName");
		String pass = request.getParameter("pass");

		HttpSession ses = req.getSession();
		
		ses.setAttribute("user", userName);
		ses.setAttribute("pwd", pass);

		RequestDispatcher rd;

		Timestamp date = new Timestamp(new java.util.Date().getTime());

		if (userName.equals("admin")) {
			
	/*		if (pass.equals("admin")) {
				rd = request.getRequestDispatcher("AdminServlet");
				rd.forward(request, response);
			} else {
				out.print("<p>Incorrect credentials </font></p>");
				rd = request.getRequestDispatcher("welcomeAdmin.html");
				rd.include(request, response);
			}*/
			
			rd = request.getRequestDispatcher("AdminServlet");
			rd.forward(request, response);

		} else {
			
			rd = request.getRequestDispatcher("UserServlet");
			rd.forward(request, response);
			
			/*try {

				conn = MyConnection.connect();
				pst = conn.prepareStatement("select * from user1 where username=?");
				pst.setString(1, userName);

				rs = pst.executeQuery();

				if (rs.next()) {
					pwd = rs.getString(2);
				}
				if (pwd.equals(request.getParameter("pass"))) {
					System.out.println("logged in is " + userName);
					ses.setAttribute("validUser", userName);
					pst = conn.prepareStatement("insert into userlog values(?,?)");
					pst.setString(1, userName);
					pst.setTimestamp(2, date);
					pst.execute();

					rd = req.getRequestDispatcher("test");
					rd.forward(request, response);

					
					 * rd = request.getRequestDispatcher("userPage.html");
					 * rd.forward(request, response);
					 
				} else {
					rd = request.getRequestDispatcher("logout.html");
					rd.forward(request, response);
				}*/

			/*} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	// chain.doFilter(request, response);
	// chain.doFilter(request, response);

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
