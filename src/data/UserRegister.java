package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class UserRegister {

	String firstNname;
	String lastName;
	String username;
	String password;
	String city;
	String mailId;
	String mobilenumber;
	
	
	public UserRegister(String firstNname, String lastName, String username, String password, String city,
			String mailId, String mobilenumber) {
		super();
		this.firstNname = firstNname;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.city = city;
		this.mailId = mailId;
		this.mobilenumber = mobilenumber;
	}


	public UserRegister() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstNname() {
		return firstNname;
	}


	public void setFirstNname(String firstNname) {
		this.firstNname = firstNname;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	@Override
	public String toString() {
		return "UserRegister [firstNname=" + firstNname + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", city=" + city + ", mailId=" + mailId + ", mobilenumber=" + mobilenumber
				+ "]";
	}

	public void user()
	{
		int c;
		do
		{
              PreparedStatmentOperation ps=new PreparedStatmentOperation();			  
			  System.out.println("1 User Reg");
			  System.out.println();
			  System.out.println("2 User Login");
			  System.out.println();
			  System.out.println("Enter User Choice");
			  Scanner sc=new Scanner(System.in);
			
			  int ch1=sc.nextInt();

			  switch(ch1)
			  {
				  case 1:
				  {
					  // User Reg
					  ps.insertUser();
					  break;
				  }
		
				  case 2:
				  {
					  System.out.println("Enter user name ");
					  String uname=sc.next();
					  System.out.println("Enter User password");
					  String upass=sc.next();
		              this.getUser(uname, upass);
					  break;			   
				  }
   		}//Switch case
          System.out.println("Do You Want To Continue Press 0 ");
		  c=sc.nextInt();
	
	}while(c!=0);//While loop
		
}
	
	public void getUser(String uname,String upass)
	{

		Scanner sc=new Scanner(System.in);

           try {
					DataBaseConnection con=new DataBaseConnection();
					Connection connection=con.getConnection();
					String s = "select * from user where Username=? and Upassword=? ";
				
					PreparedStatement psmt = connection.prepareStatement(s);
					psmt.setString(1, uname);
					psmt.setString(2, upass);
					ResultSet r = psmt.executeQuery();
					
					if (r.next()) {

						System.out.println("Login Successfull..");
						System.out.println("Hello "+uname);
						System.out.println("---------------------");

						while (true) {
							System.out.println("1 to Product Display: ");
							System.out.println("2 to Buy Product : ");
							System.out.println("3 to View cart : ");
							System.out.println("4 to Purchase the item : ");
							System.out.println("5 to Logout : ");
							System.out.println("-----------------------------");

							int b = sc.nextInt();

							if (b == 1) {
								
								// Show Product Info
								
								Product product = new Product();
								product.productInfo();

							}
							
							if(b==2)
							{
								Product p=new Product();
								p.buyProduct(uname);
								
								
							}
							if (b == 3) {
								// Add Product To Cart
								Cart cart = new Cart();
								cart.addToCart();

							}
							if (b == 4) {
								PreparedStatmentOperation ps=new PreparedStatmentOperation();
								System.out.println(ps.endUser());
								
								System.out.println("Thank You For Shopping ....");
								System.out.println("");
								System.out.println("-----------------------");
								
							}

							if(b==5) {
								//Logout
								System.out.println("Logged Out Successfully..");
								break;
							}
							
						}
					}
					else {
						System.out.println("-----------------------------");
						System.out.println("Invalid Username or Password!!");
					}
				   }
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
	}
	

	
	
}
