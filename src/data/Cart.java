package data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Cart {
			
	
		
	public void addToCart() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		

		Scanner scan = new Scanner(System.in);
		DataBaseConnection connectionTest=new DataBaseConnection();
		Connection con = connectionTest.getConnection();
		
		// create querry
		
		String s = "select ProductId,ProductName,Price from product where ProductId=?";
		
		// prepared statement
		
		ArrayList<String> cart = new ArrayList<>();
		
		    	System.out.println("Add Products To cart : ");
				System.out.println("Enter Product ID : ");
				int ID = scan.nextInt();
	
				PreparedStatement preparedStatement = con.prepareStatement(s);
				preparedStatement.setInt(1, ID);
				
				ResultSet r = preparedStatement.executeQuery();
				while (r.next()) {

						System.out.println("Products in Cart..");
						cart.add("ID : "+r.getString(1));
						cart.add("Name : "+r.getString(2));
						cart.add("Price : "+r.getString(3));
						System.out.println(cart);
						System.out.println("Total Amount : "+cart.get(2));
					}
					
				con.close();
		
			 
				}
	

}


