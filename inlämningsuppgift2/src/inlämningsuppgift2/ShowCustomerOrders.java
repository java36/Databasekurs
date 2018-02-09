package inlämningsuppgift2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ShowCustomerOrders 
{
	
	public ShowCustomerOrders() 
	{
		String customerName = askCustomerName();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "sina2119");
						
			if(customerName.equals(""))
			{
				stmt = con.prepareStatement("select customers.name as customer,\r\n" + 
						"sum(shoesordered.pairs*shoes.price) as totalSum\r\n" + 
						"from customers\r\n" + 
						"inner join orders\r\n" + 
						"on orders.customerId = customers.id\r\n" + 
						"inner join shoesordered\r\n" + 
						"on shoesOrdered.orderId = orders.id\r\n" + 
						"inner join shoes\r\n" + 
						"on shoes.id = shoesordered.shoeId\r\n" + 
						"group by customer;"); 
			}
			else
			{
				stmt = con.prepareStatement("select customers.name as customer,\r\n" + 
						"sum(shoesordered.pairs*shoes.price) as totalSum\r\n" + 
						"from customers\r\n" + 
						"inner join orders\r\n" + 
						"on orders.customerId = customers.id\r\n" + 
						"inner join shoesordered\r\n" + 
						"on shoesOrdered.orderId = orders.id\r\n" + 
						"inner join shoes\r\n" + 
						"on shoes.id = shoesordered.shoeId\r\n" + 
						"where customers.name = ?\r\n" + 
						"group by customer;"); 
				stmt.setString(1, customerName);				
			}
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				String name = rs.getString("customer");
				double sum = rs.getDouble("totalSum");
				System.out.printf("%s\t%s\n",name, sum);
				
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	 }
	
	public String askCustomerName()
	{
		String customerName = "";
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter the customer's name: ");
		
		customerName = userInput.nextLine();
		
		userInput.close();
		
		return customerName;
				
	}
	
	public static void main(String[] args)
	{
		ShowCustomerOrders scn = new ShowCustomerOrders();
	}

}
