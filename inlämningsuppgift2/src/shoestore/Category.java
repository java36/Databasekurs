package shoestore;

import java.util.ArrayList;
import java.util.List;

public class Category 
{
	private List<Shoe> shoeList = new ArrayList();

	public List<Shoe> getShoeList() {
		return shoeList;
	}

	public void setShoeList(List<Shoe> shoeList) {
		this.shoeList = shoeList;
	}
	
	public void addToShoeList(Shoe shoe)
	{
		shoeList.add(shoe);
	}
	

}
