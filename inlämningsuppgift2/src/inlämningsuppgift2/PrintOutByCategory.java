package inl�mningsuppgift2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintOutByCategory 
{
	
	public PrintOutByCategory()
	{
		Map<String, List<String>> shoesByCategory = readFromDB();
		printByCategory(shoesByCategory);
	}
	
	public Map readFromDB()
	{
		Map<String, List<String>> shoesByCategory = new HashMap<>();
		
		List<String> herrskor = new ArrayList<>();
		List<String> damskor = new ArrayList<>();
		List<String> tofflor = new ArrayList<>();
		List<String> k�ngor = new ArrayList<>();
		List<String> h�gklackar = new ArrayList<>();
		List<String> sportskor = new ArrayList<>();
		List<String> l�gskor = new ArrayList<>();
		List<String> sandaler = new ArrayList<>();
		List<String> st�vlar = new ArrayList<>();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shoestore", "root", "root");
						
			
				stmt = con.prepareStatement("select categories.category as category,\r\n" + 
						"shoes.brand as brand, shoes.model as model\r\n" + 
						"from categories \r\n" + 
						"inner join shoes\r\n" + 
						"on categories.shoeId = shoes.id;"); 
						
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				String category = rs.getString("category");
				String shoe = rs.getString("brand")+" "+rs.getString("model");
				
				switch(category)
				{
					case "herrskor" :
						herrskor.add(shoe);
						break;
					case "damskor" :
						damskor.add(shoe);
						break;
					case "k�ngor" :
						k�ngor.add(shoe);
						break;
					case "st�vlar" :
						st�vlar.add(shoe);
						break;
					case "l�gskor" :
						l�gskor.add(shoe);
						break;
					case "tofflor" :
						tofflor.add(shoe);
						break;
					case "h�gklackar" :
						h�gklackar.add(shoe);
						break;
					case "sandaler" :
						sandaler.add(shoe);
						break;
					case "sportskor" :
						sportskor.add(shoe);
						break;
				}
				
			}
			
			shoesByCategory.put("herrskor", herrskor);
			shoesByCategory.put("damskor", damskor);
			shoesByCategory.put("k�ngor", k�ngor);
			shoesByCategory.put("st�vlar", st�vlar);
			shoesByCategory.put("sportskor", sportskor);
			shoesByCategory.put("l�gskor", l�gskor);
			shoesByCategory.put("tofflor", tofflor);
			shoesByCategory.put("sandaler", sandaler);
			shoesByCategory.put("h�gklackar", h�gklackar);
			
			
			
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
		 
		return shoesByCategory;
		
	}
	
	public void printByCategory(Map<String, List<String>> map)
	{
		
		// H�r har jag anv�nt b�de lambda oh map
		map.forEach((k,v)-> System.out.println(k+"\n"+v+"\n"));
		
	} 
	public static void main(String[] args)
	{
		PrintOutByCategory pbc = new PrintOutByCategory();
	}

}
