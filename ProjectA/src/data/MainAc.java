package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainAc {

static	Connection con=null;
	
	
	public static void main(String[] args) {
		
		
		System.out.println("****  Welcome to E-Mart  ****");
		System.out.println();
		System.out.println();
		System.out.println("1 : ADMIN");
		System.out.println();
		System.out.println("2 : USER");
		System.out.println();
		System.out.println("3 : GUEST");

		
		Scanner sc=new Scanner(System.in);
	
		PreparedStatmentOperation ps=new PreparedStatmentOperation();
		
		
		System.out.println("");
		
		System.out.println("ENTER YOUR CHOICE");
		
		
		int ch=sc.nextInt();

		int c = 0;
		
		do
		{
			
			
			
			do {
				

			switch (ch) {
			case 1: {
			
				System.out.println("ADMIN");

				 System.out.println();
				 
				 System.out.println("1 Add product item");
				 System.out.println("2. Calculate Bill");
				 System.out.println("3. Display amount to End User");
				 System.out.println("4.Check Quantity");
				 System.out.println("5. Check registered user");
				 System.out.println("6. Check the particular user history");
				 
				 
				  System.out.println("Enter Admint Choice");
				  ch=sc.nextInt();
				  
				  switch(ch)
				  {
				  
				  case 1:
				  {
					
					  ps.insertProduct();
					  break;
					  
				  }
				  
				  case 2:
				  {
					  
				  }
				  
				  case 3:
				  {}
				  case 4:
				  {
					  System.out.println("Quantity of Products");
					  System.out.println();
					  ps.productQuantity();
					  break;
					  
					  
				  }
				  case 5:
				  {
					  System.out.println("Registered User ...");
					  System.out.println();
					  ps.ShowRegisterUser();
					  


										  
				  }
				  case 6:
				  {}
				  
				  }
				
				
				break;
			
			}
			case 2:
				
			{
				System.out.println(" ****USER****");
			
				  System.out.println();
				  System.out.println("11 User Reg");
				  System.out.println();
				  System.out.println("12 User Login");
				  System.out.println();
				  System.out.println("Enter User Choice");
				  int ch1=sc.nextInt();
				  
				  switch(ch1)
				  {
				  
				  case 11:
				  {
					  // User Reg
					  
					  UserRegister u1=new UserRegister();
					 DataBaseConnection db=new DataBaseConnection();
					 con=db.getConnection();
					 
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
								  
							//	ps.insertUser(fname, lname, username, password, city, mail, number);
				
						
					  
					  break;
					  
				  }

				  case 12:
				  {
					  
					  ArrayList<String> arr1=new ArrayList<>();
					  ArrayList<String> arr2=new ArrayList<>();
					  
					  
					  
					  
					  System.out.println(" **User Login**");
					  
					  String name=ps.getUser();
					  System.out.println("Hello "+name+" ....");
			 
					  System.out.println();
					  System.out.println("1 User view Product item as Sorted Order");
					  System.out.println();
					  System.out.println("2 Buy Product ");
					  System.out.println();
					  System.out.println("3 View Cart ");
					  System.out.println();
					  System.out.println("4 Purchase the item ");
					  
					  System.out.println();
					  System.out.println("Enter "+name+" Choice");
					  ch=sc.nextInt();
					  
					    switch(ch)
					    {
					    
					    case 1:
					    	
					    	   System.out.println("Products are Sorted by Price");
					    	
					    	   ps.ShowProduct();
					    	   
					    	
					    	
					    	
					    	break;
					    case 2:
					    
					    	

							try {

								int id = 0;
//								Scanner sc=new Scanner(System.in);
								
								
								System.out.println("Enter Product ID to buy");
							    sc.nextInt();
								System.out.println("Enter Quantity");
								int quant=sc.nextInt();
								DataBaseConnection con=new DataBaseConnection();
								
								Connection connection=con.getConnection();

								PreparedStatement ps2=connection.prepareStatement("update product set Quantity=Quantity-? WHERE ProductId=?");

								ps2.setInt(1,quant);
								ps2.setInt(2, id);
								
								int i=ps2.executeUpdate();
								
								System.out.println("Product buyed");
								
								System.out.println("");
								
							
							} catch (Exception e) {
								// TODO: handle exception
							}

					    	
					    	
					    	
					   // 	ps.buyProduct();
					    	
					    	break;
					    case 3:
			
					    	
					    	
					    	
					    	break;
					    case 4:
					    	
					    	
					    	break;
					     
					    
					    
					    }
					  
					  
					  
					  
					  break;
					  
				  }

							  
				  }
				  
				
				break;
			}
			
			case 3:
			{
				System.out.println("GUEST");
			
				System.out.println("1 View product item");
				
				System.out.println("2 Not purchase item");
				
				 System.out.println("Enter Guest choice");
				 ch=sc.nextInt();
				 
				 switch(ch)
				 {
				 
				 case 1:
					  
				 {
					 System.out.println("Products are ....");
					 ps.ShowProduct();
					 
					 
					 
					 break;
				 }
				 
				 case 2: 
				 {
					 break;
				 }
				 
				 }
				
				
				
				
				break;
			
			}
			
			
			default:

				if(ch!=1 ||ch!=2 ||ch!=3)
				{
			   System.out.println("You Entered wrong choice");		
				}
				break;
			
			}
			
			
		}while(ch==11);
			
						
			// Exit statment
			System.out.println("DO YOU WANT TO CONTINUE PRESS zero");
            c=sc.nextInt();


			if(c==0)
			{

				System.out.println();
				System.out.println();
				System.out.println("1 : ADMIN");
				System.out.println();
				System.out.println("2 : USER");
				System.out.println();
				System.out.println("3 : GUEST");
				System.out.println();

			}		
            
            
		}while(c==0);
	}
}
