import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Login extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>"+"<head>");
		out.println("<title>"+"DVD SHOP"+"</title>");
		out.println("</head>");
		
		out.println("<body align=center>");
		
		out.println("<form method='POST'>");
		out.println("</br>"+"</br>");
		out.println("Username"+" "+"<input type='text' name='name'>"+"<br/>"+"<br/>");
		out.println("Password"+"  "+"<input type='password' name='pass'>"+"<br/>"+"<br/>");
		
		out.println("<input type='submit' value='SUBMIT'>");
		out.println("</form>");

		out.println("</body>"+"</html>");

	}

	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		
		PrintWriter out=response.getWriter();
		String un = request.getParameter("name").toString();
		String pass = request.getParameter("pass").toString();
		
		HttpSession session = request.getSession();
		
			String sql = "SELECT * FROM customers";
			String sql2= "SELECT * FROM admins";
			DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
			ResultSet rs = da.getResultSet(sql);
			boolean client=false;
			
			while(rs.next()){
					if(un.equals(rs.getString("user_name")) && pass.equals(rs.getString("password"))){
						session.setAttribute("name",un);
						session.setAttribute("pass",pass);
/*						Cookie c=new Cookie("Cookie",un);
						c.setMaxAge(60*60);
						response.addCookie(c);*/
						response.sendRedirect("/eshop/c_items");
						client=true;
						break;
				}

			}

			if(!client){
			
			ResultSet rs2 = da.getResultSet(sql2);
			
			while (rs2.next()){
					if(un.equals(rs2.getString("admin_name")) && pass.equals(rs2.getString("password"))){
						session.setAttribute("name",un);
						session.setAttribute("pass",pass);
/*						Cookie c=new Cookie("Cookie",un);
						c.setMaxAge(60*60);
						response.addCookie(c);*/
						response.sendRedirect("/eshop/a_items");
						client=true;
						break;
					}
			}	
		}

		if(!client) {
			response.sendRedirect("/eshop/failed");
		} 
		
	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
}