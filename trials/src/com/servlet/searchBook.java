package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.dao.BookDAO;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/searchBook")
public class searchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookDAO book = new BookDAO();
	ArrayList<String> bookNames;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		//Connection con;
		try {
			response.setContentType("text/html");;
		//	con = MyConnection.connect(); 
		
			PrintWriter out = response.getWriter();

			String bookName = request.getParameter("bookName");
			
			bookNames = book.searchBook(bookName);
			
			Iterator<String> itr = bookNames.iterator();

			/*String s = "select * from books where name like '%$bookname";

			String str = s.replace("$bookname", bookName);

			String st = str.concat("%'");

			HttpSession ses = request.getSession();

			System.out.println(st);

			PreparedStatement pst = con.prepareStatement(st);
			ResultSet rst = pst.executeQuery();

			PrintWriter out = response.getWriter();
			out.println("Books found are: <br>");
			while (rst.next()) {
				out.println("<br>" + rst.getString(2));
			}*/

			System.out.println("Books found are: ");
			while(itr.hasNext())
			{
				out.println("<br>" + itr.next());
			}
			
			out.println("<br><br><br> <form action = 'getReview' method = 'post'>");
			out.print("<input type = 'text' name = 'bookName'/> &nbsp;");
			//if (ses.getAttribute("user").equals("admin")) {
				out.println("<input type = 'submit' name = 'op' value = 'Remove Book'/>");
			//} else {
				out.println("<input type = 'submit' name = 'op' value = 'Get Details'/>");
				out.println("<input type = 'submit' name = 'op' value = 'Add Review'/>");
			//}
			out.println("</form>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
