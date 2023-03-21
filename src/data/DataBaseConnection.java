package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	Connection con=null;
	
	public Connection getConnection()
	{
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Class connected");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tree","root","1234");
	//	System.out.println("Connected to database");
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return con;
		
	}
}


