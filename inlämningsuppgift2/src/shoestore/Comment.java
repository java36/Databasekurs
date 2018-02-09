package shoestore;

public class Comment 
{
	private String comment;
	private Customer customer;
	private Shoe shoe;
	
	public Comment(Customer customer, Shoe shoe, String comment)
	{
		this.customer = customer;
		this.shoe = shoe;
		this.comment = comment;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}
	
	

}
