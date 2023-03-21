package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class PreparedStatmentOperation {

	public Connection connection =null;
public 	PreparedStatement ps =null;
public 	ResultSet rs=null;

	
	
	public void insertUser()
	{
		
		
		try {

			DataBaseConnection con=new DataBaseConnection();
			connection=con.getConnection();
			Scanner sc=new Scanner(System.in);
			 
			System.out.println("  ");
			System.out.println("Enter First name");
			String fname=sc.next();
			  
			System.out.println("Enter Last name");
			String lname=sc.next();
			  

			System.out.println("Enter Username");
			String username=sc.next();
				  

			System.out.println("Enter Password");
			String password=sc.next();
			

			System.out.println("Enter city");
			String city=sc.next();
				  

			System.out.println("Enter mailid");
			String mail=sc.next();
					  

			System.out.println("Enter Number");
			String number=sc.next();


			ps=connection.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			
			ps.setString(1,fname);
			ps.setString(2, lname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, mail);
			ps.setString(7, number);
		
		int i=ps.executeUpdate();
			
		System.out.println(i+"Inserted record");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	public void insertProduct()

	{
		
		
		try {

			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Product ID");
			int pid=sc.nextInt();
			System.out.println();
			
			System.out.println("Enter Product name");
			String pname=sc.next();
			System.out.println();
			
			System.out.println("Enter Discription");
			String discription=sc.next();
			System.out.println();
			
			System.out.println("Enter Quanity");
			int quantity=sc.nextInt();
			System.out.println();
			
			System.out.println("Enter Price");
			String price=sc.next();
			
			
			DataBaseConnection con=new DataBaseConnection();
			connection=con.getConnection();

			ps=connection.prepareStatement("insert into product values(?,?,?,?,?)");
			
			ps.setInt(1,pid);
			ps.setString(2,pname);
			ps.setString(3, discription);
			ps.setInt(4,quantity);
			ps.setString(5,price);
		
		int i=ps.executeUpdate();
			
		System.out.println(i+"Inserted record");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	
	
	public void displayData()
	{
		

		try {

		
			DataBaseConnection con=new DataBaseConnection();
			
			Connection connection=con.getConnection();

			PreparedStatement ps=connection.prepareStatement("select * from user");
			 ResultSet rs=ps.executeQuery();

			
			while(rs.next())
			{
			
				System.out.println("	"+rs.getString(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"  	"+rs.getString(4)+"		 "+rs.getString(5)+" 	"+rs.getString(6)+" 	"+rs.getString(7)	);
				
			}
			
		//int i=this.ps.executeUpdate();
			
		//System.out.println(i+"Inserted record");
	
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void showProduct()
	{
		try {
			DataBaseConnection con=new DataBaseConnection();
		Connection connection=con.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from product order by Price");
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("	"+rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"  	"+rs.getInt(4)+"		 "+rs.getString(5));
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void notPurchasedProduct()
	{
		try {
			DataBaseConnection con=new DataBaseConnection();
		Connection connection=con.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from product");
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("	"+rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"  	"+rs.getInt(4)+"		 "+rs.getString(5));
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
/*

	public void buyProduct()
	{
		

		try {

			int id = 0;
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("Enter Product ID to buy");
		    sc.nextInt();
			System.out.println("Enter Quantity");
			int quant=sc.nextInt();
			DataBaseConnection con=new DataBaseConnection();
			
			Connection connection=con.getConnection();

			PreparedStatement ps=connection.prepareStatement("update product set Quantity=Quantity-? WHERE ProductId=?");

			ps.setInt(1,quant);
			ps.setInt(2, id);
	
			int i=ps.executeUpdate();
			
			System.out.println("Product buyed");
			
			System.out.println("");
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
			
		
		
	*/



	public void ShowRegisterUser()
	{
		try {
			DataBaseConnection con=new DataBaseConnection();
			Connection connection=con.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from user");
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("	"+rs.getString(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"  	"+rs.getString(4)+"		 "+rs.getString(5)+" 	"+rs.getString(6)+" 	"+rs.getString(7)	);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
	public void productQuantity()
	{
		try {
			DataBaseConnection con=new DataBaseConnection();
			Connection connection=con.getConnection();
			PreparedStatement ps1=connection.prepareStatement("	select ProductId, ProductName,Quantity from product");
			 ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"			  "+rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	public void allUserBill() throws Exception
	{
		DataBaseConnection con=new DataBaseConnection();
		Connection connection=con.getConnection();
		PreparedStatement ps1=connection.prepareStatement("SELECT *,(Quantity *Price) as Total FROM buyproduct");
		ResultSet rs=ps1.executeQuery();
		System.out.println("-------------------------------");
		int id;
		String name = null;
		int count = 0,totalprice = 0,price=0;
		
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
		   
			 name=rs.getString(2);
			 count=rs.getInt(3);
			 price=rs.getInt(4);
			totalprice=rs.getInt(5);

			
		}

		
		System.out.println("-------------------------------");
		System.out.println(" ");
		
	}
	
	public int endUser() throws Exception
	{
			DataBaseConnection con=new DataBaseConnection();
			Connection connection=con.getConnection();
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter User name");
			String nm=sc.next();
			
			PreparedStatement ps1=connection.prepareStatement("SELECT *,(Quantity *Price) as Total FROM buyproduct where Username=?");
			ps1.setString(1, nm);
			
			ResultSet rs=ps1.executeQuery();
			System.out.println("-------------------------------");
			int id;
			String name = null;
			int count = 0,totalprice = 0,price=0;
			
			
			while(rs.next())
			{
		//		System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
			   
				 name=rs.getString(2);
				 count=rs.getInt(3);
				 price=rs.getInt(4);
				totalprice=rs.getInt(5);

				totalprice=totalprice;
				
			}

			
		

		return totalprice;

		
	}
	
}
