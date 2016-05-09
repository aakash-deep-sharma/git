package com.servlet;

import java.io.IOException;
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
@WebServlet("/addReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		
		Connection con;
		try {
			con = MyConnection.connect();
		
			HttpSession hs = request.getSession();
			String bookName=(String) hs.getAttribute("bookname");
			
			PreparedStatement pst1=con.prepareStatement("select review from books where name = ?");
			pst1.setString(1,bookName);
			ResultSet rs = pst1.executeQuery();
			String oldReview = null;
			
			while(rs.next())
			{
				oldReview = rs.getString(1);
			}
			 
		String newReview = oldReview.concat(",").concat(request.getParameter("review"));
		PreparedStatement pst2=con.prepareStatement("update Books set review = ? where name = ?");
		pst2.setString(1, newReview);
		pst2.setString(2, bookName);
		pst2.execute();
		
		response.sendRedirect("adminPage.html");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
