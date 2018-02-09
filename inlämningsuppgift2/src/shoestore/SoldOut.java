package shoestore;

public class SoldOut 
{
	private int id;
	private Shoe shoe;
	
	public SoldOut(int id, Shoe shoe)
	{
		this.id = id;
		this.shoe = shoe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shoe getShoe()
	{
		return shoe;
	}
	public void setShoe(Shoe shoe)
	{
		this.shoe = shoe;
	}
	
	

}
