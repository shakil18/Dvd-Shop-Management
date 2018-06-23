import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Reqdvd extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		HttpSession session = request.getSession();
		String un = session.getAttribute("name").toString();
		String req = request.getParameter("req").toString();
		PrintWriter out=response.getWriter();
		

		String sql = "Insert into reqdvd (user_name,msg) VALUES ('"+un+"','"+req+"')";
		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/c_items");

	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
}