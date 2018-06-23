import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class c_info extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String un = session.getAttribute("name").toString();
		
		out.println("<html>");
		out.println("<head>"+"<title>Customers information</title>"+"</head>");
		out.println("<body>");
	
				out.println("<table border=1 align=center>");
					out.println("<thead>");
						out.println("<tr>");
							out.println("<td>User ID</td>");
							out.println("<td>User NAME</td>");
						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
						try{
								DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
								String sql = "SELECT * from customers";
								ResultSet rs = dc.getResultSet(sql);
								
									while(rs.next()){
										out.println("<tr>");
										out.println("<td>");
											out.println(rs.getString("user_id"));
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("user_name"));
										out.println("</td>");
										out.println("<tr>");
								
									}
								out.println("</tbody>");
								out.println("</table>");

								out.println("<form action='/eshop/a_items'>"+
								    "<input type='submit' value='Back'>"+
								"</form>");


								out.println("</body>");
								out.println("</html>");
							}

							catch(Exception ex){
								ex.printStackTrace();
							}

	}
    

}
