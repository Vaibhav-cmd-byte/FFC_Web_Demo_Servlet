

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FFC
 */
@WebServlet("/W")
public class W extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public W() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try	
		{
			System.out.println("check1");
			Class.forName("com.mysql.cj.jdbc.Driver");  
			System.out.println("check2");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FFC","root","1234567890"); 
			Statement st=con.createStatement();
			System.out.println("check3 connection");
			String Customer_Name = request.getParameter("name");
			String Phone_No = request.getParameter("number");
			String City = request.getParameter("city");
			String Email_Id = request.getParameter("email");
			String Password = request.getParameter("password");
			System.out.println("check4");
	        String sql="insert into customers values('"+Customer_Name+"','"+Phone_No+"','"+City+"','"+Email_Id+"','"+Password+"')";
	    	System.out.println("check5");
			st.executeUpdate(sql);
//    		PrintWriter P= response.getWriter();
//    		P.print("<h1>Hello  "+Name);
            System.out.println("Successfully Inserted");
			System.out.println("Success");
			response.sendRedirect("Sign.html");
		}
		catch(Exception e)
		{
			System.out.println("Error--"+e);
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
