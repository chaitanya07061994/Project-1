package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static	Connection con=null;

	
	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		PreparedStatmentOperation ps=new PreparedStatmentOperation();
		System.out.println("");
		int ch;
     	int c = 0;
		
		do
		{
			System.out.println("****  Welcome to E-Mart  ***");
			System.out.println();
			System.out.println("1 : ADMIN");
			System.out.println();
			System.out.println("2 : USER");
			System.out.println();
			System.out.println("3 : GUEST");
			System.out.println();
			
			System.out.println("ENTER YOUR CHOICE");
			
			
			ch=sc.nextInt();
			
			switch (ch) {
				case 1: {
							System.out.println("ADMIN");
			     			System.out.println();
							Admin ad=new Admin();
							ad.admin();
						
							break;
				        }
				
				case 2:
			            {
							System.out.println(" ****USER****");
							new UserRegister().user();
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
									 ps.showProduct();
									 break;
								 }
							     case 2: 
								 {
									 
									 System.out.println("Not Purchased Products are ....");
									 ps.notPurchasedProduct();
									
									 
									 break;
								 }
						 
					}
					
					break;
				   }
				}
			// Exit statment
			System.out.println("DO YOU WANT TO CONTINUE PRESS zero");
            c=sc.nextInt();
		}while(c==0);
	}

}



