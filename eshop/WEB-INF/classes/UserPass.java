import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserPass extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>"+"<head>");
		out.println("<title>"+"Password Update"+"</title>");
		out.println("</head>");
		
		out.println("<body align=center>");
		
		out.println("<form method='POST'>");
		out.println("</br>"+"</br>");

		out.println("Old Password"+" "+"<input type='password' name='opass'>"+"<br/>"+"<br/>");
		out.println("New Password"+"  "+"<input type='password' name='npass'>"+"<br/>"+"<br/>");
		
		out.println("<input type='submit' value='SUBMIT'>");
		out.println("</form>");

		out.println("</body>"+"</html>");

	}

	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String opass = request.getParameter("opass").toString();
		String npass = request.getParameter("npass").toString();
		String un = session.getAttribute("name").toString();

		
			String sql = "UPDATE customers SET password='"+npass+"' WHERE user_name='"+un+"' ";
			String sql2 = "Select * from customers";
			DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
			ResultSet rs = da.getResultSet(sql2);
			boolean client=false;
			
			while(rs.next()){
					if(un.equals(rs.getString("user_name")) && opass.equals(rs.getString("password"))){
						da.executeQuery(sql);
						response.sendRedirect("/eshop/c_items");
						client=true;
						break;
				}

			}

			if(!client){
			
			response.sendRedirect("/eshop/failed");
		}

		
	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
}