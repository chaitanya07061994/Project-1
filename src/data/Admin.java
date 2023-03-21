package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
			
		
	
	public void admin() throws Exception {

		PreparedStatmentOperation ps=new PreparedStatmentOperation();

				Scanner sc=new Scanner(System.in); 
				int ch;
				while (true) {
					 
					 System.out.println("1. Add product item");
					 System.out.println("2. Calculate Bill");
					 System.out.println("3. Display amount to End User");
					 System.out.println("4. Check Quantity");
					 System.out.println("5. Check registered user");
					 System.out.println("6. Check the particular user history");
					 System.out.println("7. Logout...");
					 
					  System.out.println("Enter Admint Choice");
					  ch=sc.nextInt();

				if (ch==1) {

					  ps.insertProduct();
					 
					
					
				}
				if(ch==2) {
					
					// Calculate bill with username
					ps.allUserBill();
					
				}
				if(ch==3) {
	
					// End User 
					System.out.println(ps.endUser());
					System.out.println("-------------------------------");
					System.out.println(" ");
					

				}
				
				if(ch==4) {
					//Check quanity
					ps.productQuantity();
					
					
				}
				if(ch==5)
				{
					System.out.println("");
					//Check User Details
					this.getUserDetails();
				}
				
				if(ch==6)
				{
					
				}
				if(ch==7)
				{
					
					System.out.println("Logout ....");
					break;
				}
				else {
					
					}
				}
			}
		
		public void getUserDetails() throws ClassNotFoundException, SQLException {
			
			// call the connection
			
			
			DataBaseConnection db=new DataBaseConnection();
			Connection con = db.getConnection();
			String s = "select Fname,Lname,Username from user";
			PreparedStatement preparedStatement = con.prepareStatement(s);
			ResultSet resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				System.out.println("Registered User Details..");
				System.out.println("-------------------------");
				System.out.println("Fname : "+resultSet.getString(1));
				System.out.println("Lname : "+resultSet.getString(2));
				System.out.println("Username : "+resultSet.getString(3));
				System.out.println("-------------------------");
				
			}
			

			
		}
}

