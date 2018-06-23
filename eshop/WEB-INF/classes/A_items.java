import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class A_items extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String un = session.getAttribute("name").toString();


		out.println("<html>");
		out.println("<head>"+"<title>Products</title>"+"</head>");
		out.println("<body>");
		out.println("Welcome "+"<i>"+un+"</i>"+"</br>"+"</br>");
		out.println("DVD Search"+
			"<form method='GET' action='/eshop/adminprsearch'>"+
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
							out.println("<td>DELETE</td>");
							out.println("<td>EDIT INFO</td>");
						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
						try{
								DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
								String sql = "SELECT * from dvd";
								ResultSet rs = dc.getResultSet(sql);
								
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
											out.println(rs.getString("price"));
										out.println("</td>");
										out.println("<td>");
											out.println(rs.getString("quantity"));
										out.println("</td>");

                                        out.println("<td>");
											out.println("<input type='hidden' name='del' value='"+rs.getString("p_id")+"'>");
											out.println("<input type='submit' value='Delete'>");
                                            out.println("</form>");
										out.println("</td>");

                                         out.println("<td>");
                                        out.println("<form action='/eshop/dvdup_u'>");
											out.println("<input type='hidden' name='edit' value='"+rs.getString("p_id")+"'>");
											out.println("<input type='submit' value='Edit'>");
                                            out.println("</form>");

										out.println("</td>");

										out.println("</tr>");
										out.println("</form>");
									}
								out.println("</tbody>");
								out.println("</table>");

								out.println("CUSTOMER Search"+
											"<form method='GET' action='/eshop/admincustomsearch'>"+
											"<input type='text' name='csearch'>"+
											"</form>"
											+"</br>"+"</br>");

								out.println("<form action='/eshop/ad_dvd'>"+
								    "<input type='submit' value='ADD DVD'>"+
								"</form>");

								out.println("<form action='/eshop/c_info'>"+
								    "<input type='submit' value='Customer INFO'>"+
								"</form>");

								out.println("<form action='/eshop/req_msg'>"+
								    "<input type='submit' value='Request Messeges'>"+
								"</form>");

								out.println("<form action='/eshop/adminpass'>"+
									"<input type='submit' value='Change Password'>"+
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
		String pid = request.getParameter("del").toString();

		PrintWriter out=response.getWriter();
		

		String sql = "DELETE FROM dvd where p_id like '"+pid+"'";
		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/a_items");

	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
