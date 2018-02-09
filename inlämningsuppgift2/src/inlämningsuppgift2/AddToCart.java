package inlämningsuppgift2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddToCart 
{
	private int customerId;
	private int shoeId;
	private Integer orderId;
	
	public AddToCart()
	{
		System.out.println("Add To Cart");
		
		customerId = userChooseCustomerId();
		shoeId = userChooseShoeId();
		orderId = userChooseOrderId(customerId);
		
		
		Connection con = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "root");
						
			
				stmt = con.prepareCall("call AddToCart(?,?,?)");
				
				stmt.setInt(1, customerId);
				stmt.setInt(2, shoeId);

				if(orderId == -1)
				{
					stmt.setString(3, null);
				}
				else
				{
					stmt.setInt(3, orderId);					
				}
			
				stmt.execute();
			
				rs = stmt.getResultSet();

				try
				{
					while (rs.next()) 
					{ 

						String soldOutMessage = rs.getString("the product is sold out");
						System.out.println(soldOutMessage);
					}
					
				}
				catch(NullPointerException n)
				{
					System.out.println("Order registered");
				}
					
				
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try {

				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private int userChooseCustomerId()
	{
		int customerId = 0; 
		List<String> customerNames = new ArrayList<>();
		Scanner userInput = new Scanner(System.in);
		int index = 0;
		String customerName = "";
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "sina2119");
						
			
				stmt = con.prepareStatement("select name from customers;"); 
			
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				String name = rs.getString("name");
				customerNames.add(name);				
			}
			
			System.out.println("Please choose a customer: (number)");
			System.out.println();
			
			for(int i=0; i<customerNames.size(); i++)
			{
				System.out.println(i+"\t"+customerNames.get(i));
			}
			
			try
			{
				index = userInput.nextInt();			
				
				while(index < 0 || index >= customerNames.size())
				{
					System.out.println("Number out of range, please try again");
					index = userInput.nextInt();			
					
				}
			}
			catch (Exception e)
			{
				System.out.println("Number not recognized, please try again ");
			}
			
			customerName = customerNames.get(index);
			
			stmt2 = con.prepareStatement("select id from customers where name = ?;"); 
			
			stmt2.setString(1, customerName); 
			
			rs2 = stmt2.executeQuery();
			
			while (rs2.next()) 
			{ 
				customerId = rs2.getInt("id");			
			}
			
			
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try {
				//userInput.close();
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		return customerId;

	}
	
	private int userChooseShoeId()
	{
		int shoeId = 0; 
		List<String> shoeList = new ArrayList<>();
		Scanner userInput = new Scanner(System.in);
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "sina2119");
						
			
			stmt = con.prepareStatement("select brand, model, colour, size, price from shoes order by id;"); 
			
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				String shoeInfo = rs.getString("brand")+
				"\t"+rs.getString("model")+"\t"+rs.getString("colour")
				+"\t"+rs.getInt("size")+"\t"+rs.getDouble("price")+" kr";
				shoeList.add(shoeInfo);				
			}
			
			System.out.println("Please choose a shoe: (number)");
			System.out.println();
			
			for(int i=0; i<shoeList.size(); i++)
			{
				System.out.println(i+"\t"+shoeList.get(i));
			}
			
			try
			{
				shoeId = userInput.nextInt();			
				
				while(shoeId < 0 || shoeId >= shoeList.size())
				{
					System.out.println("Number out of range, please try again");
					shoeId = userInput.nextInt();			
					
				}
			}
			catch (Exception e)
			{
				System.out.println("Number not recognized, please try again ");
			}
			
			shoeId++;
			
						
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try {
			//	userInput.close();
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		return shoeId;
	}
	
	
	
	
	
	
	private Integer userChooseOrderId(int customerId)
	{
		int ordernum = 0; 
		List<String> orderDateList = new ArrayList<>();
		List<Integer> orderIdList = new ArrayList<>();
		Scanner userInput = new Scanner(System.in);
		String orderDate = null;
		Integer orderId = 0;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		

		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "sina2119");
						
			
			stmt = con.prepareStatement("select id, created from orders where customerId = ? and executed = 0 ;"); 
			
			stmt.setInt(1, customerId);
			
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				Integer id = rs.getInt("id");
				orderIdList.add(id);
				orderDate = rs.getTimestamp("created").toString();
				orderDateList.add(orderDate);				
			}
			
			orderDateList.add("Place a new order");
			
			System.out.println("Please choose an order: (number)");
			System.out.println();
			
			for(int i=0; i<orderDateList.size();i++)
			{
				System.out.println(i+"\t"+orderDateList.get(i));
			}
			
			try
			{
				ordernum = userInput.nextInt();			
				
				while(ordernum < 0 || ordernum >= orderDateList.size())
				{
					System.out.println("Number out of range, please try again");
					ordernum = userInput.nextInt();			
					
				}
			}
			
			catch (Exception e)
			{
				System.out.println("Number not recognized, please try again ");
			}
			

			
			if(ordernum == orderDateList.size()-1)
			{
				orderId = -1;
			}
			else
			{
				orderId = orderIdList.get(ordernum);
			}
			
						
			}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try 
			{
				userInput.close();
				rs.close();
				stmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		return orderId;
	}

	public static void main(String[] args)
	{
		AddToCart atc = new AddToCart();
	}


}