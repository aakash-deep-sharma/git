package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/getReview")
public class GetReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		Connection con;
		try {
			con = MyConnection.connect();

			String bookName = request.getParameter("bookName");

			HttpSession hs = request.getSession();
			hs.setAttribute("bookname", bookName);

			String option = request.getParameter("op");
			switch (option) {
			case "Get Details":
				PreparedStatement pst = con.prepareStatement("select * from books where name like ?");
				pst.setString(1, bookName);
				ResultSet rst = pst.executeQuery();

				PrintWriter out = response.getWriter();
				out.print("Book reviews of <h3>");
				while (rst.next()) {
					String str = rst.getString(3);
					String[] str1 = str.split(",");

					out.print(" " + rst.getString(2) + "</h3> are :");
					for (int i = 0; i < str1.length; i++) {
						out.println("<br>"+ (i+1) +" :- " + str1[i]);
					}
				}
				break;

			case "Add Review":
				response.sendRedirect("addReview.html");
				break;

			case "Remove Book":
				response.sendRedirect("removeBook");
				break;

			default:
				break;
			}

			System.out.println("book review ");

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
