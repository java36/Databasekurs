package inlämningsuppgift2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeConversion 
{
	public static void main(String[] something)
	{
		LocalDateTime l = LocalDateTime.now();
		System.out.println(l);
		Timestamp t = Timestamp.valueOf(l);
		System.out.println(t);
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "sina2119");
						
			
			stmt = con.prepareStatement("select created from orders where id = ?"); 
			
			stmt.setInt(1, 1);
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				Timestamp incoming = rs.getTimestamp("created");
				System.out.println(incoming);
				
				if(t.before(incoming))
				{
					System.out.println("Its too early");
				}
				else if(t.after(incoming))
				{
					System.out.println("It's too late");
				}
				else if(t.equals(incoming))
				{
					System.out.println("Right on time");
				}
				else
				{
					System.out.println("An error occurred");
				}
				
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

}
