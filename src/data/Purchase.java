package data;

import java.io.IOException;
import java.sql.SQLException;

public class Purchase  {
	
	public void PurchaseItem() throws NumberFormatException, ClassNotFoundException, IOException, SQLException {
				
				System.out.println("Checkout Page..");
				System.out.println("Confirm Your Order..");
				Cart cart = new Cart();
				cart.addToCart();
		
	}

}

