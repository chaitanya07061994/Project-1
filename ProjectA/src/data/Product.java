package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Product {
	

	public void productInfo() throws ClassNotFoundException, SQLException {

		DataBaseConnection connectionTest = new DataBaseConnection();
		Connection con = connectionTest.getConnection();
		String s = "select * from product order by ProductId";
		PreparedStatement preparedStatement = con.prepareStatement(s);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			System.out.println("Product Details");
			System.out.println("ProductID : " + resultSet.getInt(1));
			System.out.println("ProductName : " + resultSet.getString(2));
			System.out.println("ProductDetails : " + resultSet.getString(3));
			System.out.println("Quantity : " + resultSet.getInt(4));
			System.out.println("ProductPrice :" +resultSet.getString(5));
			System.out.println("");
			System.out.println("------------------------------------");

		}
		con.close();

	}
	
	public void getQuantity() throws ClassNotFoundException, SQLException {
		
		                Scanner scan = new Scanner(System.in);
						
		                System.out.println("------------------------");
						
		                System.out.println("Check Product Quantity..");
						
		                System.out.println("Enter Product ID : ");
			            int ID = scan.nextInt();
				DataBaseConnection connectionTest = new DataBaseConnection();
				Connection con = connectionTest.getConnection();
				String s = "select ProductId,ProductName,Quantity from product where ProductId =?";
				PreparedStatement preparedStatement = con.prepareStatement(s);
				preparedStatement.setInt(1, ID);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {

					System.out.println("Product Details");
					System.out.println("ProductID : " + resultSet.getInt(1));
					System.out.println("ProductName : " + resultSet.getString(2));
					System.out.println("Quantity : " + resultSet.getInt(3));
					System.out.println("------------------------------------");

				}
				con.close();
	}
	
	public void buyProduct(String uname)
	{
		
		try {

			int id = 0;
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("Enter Product ID to buy");
		    id=sc.nextInt();
			System.out.println("Enter Quantity");
			int quant=sc.nextInt();
			DataBaseConnection con=new DataBaseConnection();
			
			Connection connection=con.getConnection();

			PreparedStatement ps2=connection.prepareStatement("update product set Quantity=(Quantity-?) WHERE ProductId=?");

			ps2.setInt(1,quant);
			ps2.setInt(2, id);
			
			int i=ps2.executeUpdate();
		
			this.insertIntoBuy(id, quant,uname);
			System.out.println(i+"Product buyed");
			
			System.out.println("");

			
		
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
	
	public void insertIntoBuy(int id,int qunt,String uname) throws SQLException
	{
		DataBaseConnection con=new DataBaseConnection();
		
		Connection connection=con.getConnection();

		PreparedStatement ps2=connection.prepareStatement("select P.ProductId,P.Quantity,P.Price from product P where ProductId=?");
		ps2.setInt(1,id);
		ResultSet rs=ps2.executeQuery();
		
		/*while(rs.next())
		{
			
			System.out.println("  "+rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
		}
		
		*/
		System.out.println(" 1");
		PreparedStatement ps3=connection.prepareStatement("insert into buyproduct values(?,?,?,?)");
		System.out.println("2");
		int pid,quant;
		String price;
		
		System.out.println("3");
		
		while(rs.next())
		{
		  
//		    pid=rs.getInt(1);
//			uname=rs.getString(uname);
//			quant=rs.getInt(3);
//			price=rs.getString(4);
//
		 
			System.out.println("4");
		   ps3.setInt(1,rs.getInt(1));
		   ps3.setString(2,rs.getString(2));
		   ps3.setInt(3,rs.getInt(3));
		   ps3.setString(4,rs.getString(4));
			int i=ps3.executeUpdate();
			System.out.println(i+" Inserted into buytable ");
			
		}
		

		
	}

}

