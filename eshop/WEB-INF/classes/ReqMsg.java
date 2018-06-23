import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ReqMsg extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String un = session.getAttribute("name").toString();
		
		out.println("<html>");
		out.println("<head>"+"<title>Request Messeges</title>"+"</head>");
		out.println("<body>");
		out.println("Welcome "+"<i>"+un+"</i>"+"</br>"+"</br>");

				out.println("<table border=1 align=center>");
					out.println("<thead>");
						out.println("<tr>");
							out.println("<td>PRODUCT NAME</td>");
							out.println("<td>QUANTITY</td>");
							out.println("<td>PRICE</td>");
							out.println("<td>MODIFY</td>");

						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
						try{
								DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
								String sql = "SELECT * from purchased WHERE user_name='"+un+"'";
								ResultSet rs = dc.getResultSet(sql);
								int total=0;
								
									while(rs.next()){
										out.println("<form method='POST'>");
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
										
										out.println("<td>");
										out.println("<input type='hidden' name='oid' value='"+rs.getString("o_id")+"'>");
										out.println("<input type='submit' value='Delete'>");
										out.println("</td>");

										out.println("</tr>");
										total=total+Integer.parseInt(rs.getString("price"));
										out.println("</form>");
									}
								out.println("</tbody>");
								out.println("</table>");
								out.println("Total= "+total+"/- tk.");						

								out.println("<form action='/eshop/final'>"+
							 				"<input type='submit'>"+
											"</form>");							
								out.println("</body>");
								out.println("</html>");
							}

							catch(Exception ex){
								ex.printStackTrace();
							}

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
			try{
			HttpSession session = request.getSession();
			String un = session.getAttribute("name").toString();
			String oid = request.getParameter("oid").toString();

			PrintWriter out=response.getWriter();
			
			String sql = "DELETE FROM purchased WHERE o_id ='"+oid+"'";
			DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
			da.executeQuery(sql);
			response.sendRedirect("/eshop/confirm");

		}
		
		catch(Exception ex){
				ex.printStackTrace();
			}
		}

}