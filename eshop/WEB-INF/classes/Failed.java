import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Failed extends HttpServlet{
			public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		try{
		
		PrintWriter out=response.getWriter();
			out.println("<html>"+
				
			"<head>"+
			"<title>Failed</title>"+
			"</head>"+
			
			"<body>"+
			"<p style='color:red'>Invalid Username or Password!</p>"+
			"</body>"+
			
			"</html>");
			
		}
	
	catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


