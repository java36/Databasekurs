package shoestore;

public class ShoesOrdered 
{
	private int id;
	private int orderId;
	private int shoeId;
	private int pairs;
	private Order order;
	private Shoe shoe;
	
	public ShoesOrdered(int id, Order order, Shoe shoe, int pairs)
	{
		this.id = id;
		this.order = order;
		this.shoe = shoe;
		this.pairs = pairs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}
	public int getShoeId() 
	{
		return shoeId;
	}

	public int getPairs() 
	{
		return pairs;
	}

	public void setPairs(int pairs) 
	{
		this.pairs = pairs;
	}

	public Order getOrder() 
	{
		return order;
	}

	public void setOrder(Order order) 
	{
		this.order = order;
		orderId = order.getId();

	}

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) 
	{
		this.shoe = shoe;
		shoeId = shoe.getId();

	}
	
	


}
