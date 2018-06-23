import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class AdminCustomSearch extends HttpServlet{

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String un = session.getAttribute("name").toString();
		String cn = request.getParameter("csearch").toString();

				
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
								String sql = "SELECT * from customers WHERE user_name like '%"+cn+"%' ";
								DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
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