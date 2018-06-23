import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataAccess
{
	private Connection connection;
	private Statement statement;
	
	private String host = "localhost";
	private String database = "cdcol";
	private String username = "root";
	private String password = "";
	private int port = 3306;
	
	public DataAccess()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database, this.username, this.password);
			this.statement = this.connection.createStatement();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public DataAccess(String host, int port, String database, String username, String password)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, username, password);
			this.statement = this.connection.createStatement();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String sql)
	{
		try
		{
			return this.statement.executeQuery(sql);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean executeQuery(String sql)
	{
		try
		{
			return this.statement.execute(sql);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	protected void finalize()
	{
		try
		{
			this.statement.close();
			this.connection.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}