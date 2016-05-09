package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
@WebServlet("/removeBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBook() {
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
			PrintWriter out = response.getWriter();
			HttpSession hs = request.getSession();
			String bookName = (String) hs.getAttribute("bookname");
			
			//PreparedStatement pst = con.prepareStatement("select * from books where name=?");
			//pst.setString(1,bookName);
			//ResultSet rst = pst.executeQuery();

		
			//if(rst.next()) {
				PreparedStatement ps = con.prepareStatement("delete from books where name=?");
				ps.setString(1,bookName);
				ps.execute();


				out.println(bookName+ "is removed from database ");
				
			
		
			out.println("wait untill you are redirected to your home page..") ;
			
		response.setHeader("Refresh", "5;adminPage.html");
		
				
		} catch (Exception e) {
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
