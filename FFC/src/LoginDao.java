import java.sql.*;

public class LoginDao {

public static boolean validate(String Email_Id,String Password){
boolean status=false;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FFC","root","1234567890"); 
  PreparedStatement ps=con.prepareStatement("select * from customers where Email_Id=? and Password=?");
	ps.setString(1,Email_Id);
	ps.setString(2,Password);
	ResultSet rs=ps.executeQuery();
	status=rs.next();	
}catch(Exception e){System.out.println(e);}
return status;
}
}
