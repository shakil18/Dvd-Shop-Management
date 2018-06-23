import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DvdUp_u extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		
		out.println("<html>"+"<head>");
		out.println("<title>"+"EDIT DVD"+"</title>");
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
		HttpSession session = request.getSession();
		String pid = request.getParameter("edit").toString();
		String nm = request.getParameter("p_name").toString();
		String gn = request.getParameter("p_genre").toString();
		int yr = Integer.parseInt(request.getParameter("p_year"));
		int pr = Integer.parseInt(request.getParameter("price"));
		int qn = Integer.parseInt(request.getParameter("quantity"));

		PrintWriter out=response.getWriter();
		
		String sql = "UPDATE dvd SET p_name='"+nm+"' ,p_genre='"+gn+"' ,p_year="+yr+" ,price="+pr+", quantity="+qn+" WHERE p_id="+pid+"";		
		DataAccess da = new DataAccess("localhost",3306,"dvdshop","root","");
		da.executeQuery(sql);
		response.sendRedirect("/eshop/a_items");

	}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
    
    
    

}
