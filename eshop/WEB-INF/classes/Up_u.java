import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Up_u extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();

        out.println("<html>"+"<head>");
		out.println("<title>"+"modify Customers"+"</title>");
		out.println("</head>");
        out.println("<body align=center>");
        try{
        DataAccess dc = new DataAccess("localhost", 3306, "dvdshop", "root", "");
        String user_id = request.getParameter("user_id").toString();
        String sql = "SELECT * from customers  where user_id like '"+user_id+"' ";
        ResultSet rs = dc.getResultSet(sql);
		
		
		
		out.println("<form method='POST'>");
		out.println("</br>"+"</br>");
        //out.println("user Name "+"  "+"<input type='text' name='p_name' value='"+rs.getString("user_id")+"'>"+"<br/>"+"<br/>");
        out.println("<input type='hidden' name='user_id' value='"+rs.getString("user_id")+"'>");
		out.println("User Password"+" "+"<input type='text' name='p_genre'value='"+rs.getString("password")+"'>"+"<br/>"+"<br/>");
		out.println("<input type='submit' value='SUBMIT'>");
		out.println("</form>");

		out.println("</body>"+"</html>");
        }
        catch(Exception ex){
								ex.printStackTrace();
							}


	}
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		
		PrintWriter out=response.getWriter();
		String password = request.getParameter("password").toString();
	   	String user_id = request.getParameter("user_id").toString();
		//PrintWriter out=response.getWriter();
		String sql = "UPDATE customers SET password='"+password+"' WHERE user_id='"+user_id+"' ";

		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/c_info");
		
	}
	 
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
    
    
    

}
