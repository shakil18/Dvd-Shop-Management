import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ad_dvd extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		
		out.println("<html>"+"<head>");
		out.println("<title>"+"ADD DVD"+"</title>");
		out.println("</head>");
		
		out.println("<body align=center>");
		
		out.println("<form method='POST'>");
		out.println("</br>"+"</br>");
		out.println("DVD Name "+"  "+"<input type='text' name='p_name'>"+"<br/>"+"<br/>");
		out.println("DVD GENRE"+" "+"<input type='text' name='p_genre'>"+"<br/>"+"<br/>");
        out.println("Year     "+"  "+"<input type='text' name='p_year'>"+"<br/>"+"<br/>");
		out.println("Price    "+"   "+"<input type='text' name='price'>"+"<br/>"+"<br/>");
        out.println("Quantity "+""+"<input type='text' name='quantity'>"+"<br/>"+"<br/>");
		out.println("<input type='submit' value='SUBMIT'>");
		out.println("</form>");

		out.println("</body>"+"</html>");


	}
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		
		PrintWriter out=response.getWriter();
		String p_name = request.getParameter("p_name").toString();
		String p_genre = request.getParameter("p_genre").toString();
        String p_year = request.getParameter("p_year").toString();
		String price = request.getParameter("price").toString();
        String quantity = request.getParameter("quantity").toString();
		
		//PrintWriter out=response.getWriter();
		

		String sql = "Insert into dvd (p_name,p_genre,p_year,price,quantity) VALUES ('"+p_name+"','"+p_genre+"','"+p_year+"','"+price+"','"+quantity+"')";
		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/a_itemscc");
		
	}
	 
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
    
    
    

}
