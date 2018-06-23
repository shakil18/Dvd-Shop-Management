import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Final extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String un = session.getAttribute("name").toString();
		
		out.println("<html>");
		out.println("<head>"+"<title>Final</title>"+"</head>");
		out.println("<body>");
		out.println("Thankyou "+"<i>"+un+"</i>"+"</br>"+"</br>");

				out.println("<table border=1 align=center>");
					out.println("<thead>");
						out.println("<tr>");
							out.println("<td>PRODUCT NAME</td>");
							out.println("<td>QUANTITY</td>");
							out.println("<td>PRICE</td>");

						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
						try{
								DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
								String sql = "SELECT * from purchased WHERE user_name='"+un+"'";
								ResultSet rs = dc.getResultSet(sql);
								int total=0;
								
									while(rs.next()){
										out.println("<tr>");

										out.println("<td>");
											out.println(rs.getString("p_name"));
										out.println("</td>");

										out.println("<td>");
											out.println(rs.getString("quantity"));
										out.println("</td>");

										out.println("<td>");
											out.println(rs.getString("price")+" tk");
										out.println("</td>");

										out.println("</tr>");

										total=total+Integer.parseInt(rs.getString("price"));
										out.println("</form>");
									}
								out.println("</tbody>");
								out.println("</table>");
								out.println("</br>");
								out.println("Total= "+total+"/- tk.");
								out.println("</br>"+"Purchased Completed!");

								out.println("</br>"+"<form action='/eshop/confirm'>"+
								    "<input type='submit' value='Back'>"+
								"</form>");	
								
								out.println("</br>"+"<form action='/eshop/c_items'>"+
								    "<input type='submit' value='Home'>"+
								"</form>");							
								out.println("</body>");
								out.println("</html>");

								sql= "DELETE FROM purchased WHERE user_name='"+un+"'";
								dc.executeQuery(sql);
							}

							catch(Exception ex){
								ex.printStackTrace();
							}

	}

}