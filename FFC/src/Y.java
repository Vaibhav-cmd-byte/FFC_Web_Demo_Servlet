

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Y
 */
@WebServlet("/Y")
public class Y extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Y() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Entered Y");
		String Email_Id=request.getParameter("email");
		String Password=request.getParameter("password");
		System.out.println("Checked String in Y");		
		if(LoginDao.validate(Email_Id, Password)){
			System.out.println("Successfully Entered to Home");
			RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			rd.forward(request,response);
			PrintWriter P =response.getWriter();
			String name=request.getParameter("Customer_Name");  
		    P.print("Welcome "+name);
		    System.out.println("NAME ENTERED");
		}
		else{
			System.out.println("Wrong Info in  Y");
			RequestDispatcher rd=request.getRequestDispatcher("Sign.html");
			out.print("Sorry username or password error");
			rd.include(request,response);
		}		System.out.println("Exited Y");
		
//		try
//        {
//			System.out.println("check1");
//			Class.forName("com.mysql.cj.jdbc.Driver");  
//			System.out.println("check2");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FFC","root","1234567890"); 
//            PreparedStatement st;
//            ResultSet rs;
//            System.out.println("Check1");
//            st=con.prepareStatement("Select Email_Id,Password from customers where Email_Id=? and Password=?");
//            //select * from customers where  Email_Id='"+request.getParameter("email")+"'"
//            System.out.println("Check2");
//            st.setString(1, "email"); 
//            System.out.println("Check3");
//            st.setString(2, "password");
//            System.out.println("Check4");
//            rs = st.executeQuery();
//            System.out.println("Check5");
//           rs.next();
//            System.out.println("Selected");
//           
//            System.out.println("Successful");
//    		PrintWriter P= response.getWriter();
//    		
//   		    P.print("Welcome "+"Home");
//        }
//        catch(Exception e)
//        {
//            System.out.println("Error---"+e);
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
