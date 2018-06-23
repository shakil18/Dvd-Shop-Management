import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class PrSearch extends HttpServlet{

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String un = session.getAttribute("name").toString();
		String pn = request.getParameter("search").toString();
				
				out.println("<html>");
				out.println("<head>"+"<title>Products</title>"+"</head>");
				out.println("<body>");
				out.println("Welcome "+"<i>"+un+"</i>");
				out.println("<form action='/eshop/c_items'>"+
							"<input type='submit' value='Home'>"+
							"</form>");

				out.println("Search"+
							"<form method='GET' action='/eshop/prsearch'>"+
							"<input type='text' name='search'>"+
							"</form>"
							+"</br>"+"</br>");
			
					out.println("<table border=1 align=center>");
					out.println("<thead>");
						out.println("<tr>");
							out.println("<td>NAME</td>");
							out.println("<td>GENRE</td>");
							out.println("<td>YEAR</td>");
							out.println("<td>PRICE</td>");
							out.println("<td>QUANTITY</td>");
							out.println("<td>ADD</td>");
						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
						try{
								String sql = "SELECT * from dvd WHERE p_name like '%"+pn+"%' OR p_genre like '%"+pn+"%'";
								DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
								ResultSet rs = da.getResultSet(sql);
									while(rs.next()){
										out.println("<form method='POST'>");
										out.println("<tr>");
										out.println("<td>");
											out.println(rs.getString("p_name"));
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("p_genre"));
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("p_year"));
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("price")+" tk");
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("quantity"));
										out.println("</td>");

										out.println("<td>");
											out.println("<input type='hidden' name='pname' value='"+rs.getString("p_name")+"'>");
											out.println("<input type='hidden' name='pr' value='"+rs.getString("price")+"'>");
											out.println("<input type='submit' value='Add to Cart'>");
										out.println("</td>");

										out.println("</tr>");
										out.println("</form>");																				
									}
										out.println("</tbody>");
										out.println("</table>");
										out.println("</br>"+"<form action='/eshop/confirm' align=center>"+
								    				"<input type='submit' value='Confirm'>"+
													"</form>");
										
										out.println("<form method='POST' action='/eshop/reqdvd'>"+
													"<textarea name='req'>"+
													"</textarea>"+
													"</br>"+
								    				"<input type='submit' value='Requset DVD'>"+
													"</form>");
										

								out.println("</body>");
								out.println("</html>");
							}

							catch(Exception ex){
								ex.printStackTrace();
							}

	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		HttpSession session = request.getSession();
		String un = session.getAttribute("name").toString();
		String pname = request.getParameter("pname").toString();
		int pr = Integer.parseInt(request.getParameter("pr"));

		PrintWriter out=response.getWriter();
		

		String sql = "Insert into purchased (user_name,p_name,quantity,price) VALUES ('"+un+"','"+pname+"',1,"+pr+")";
		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/c_items");

	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}	
}