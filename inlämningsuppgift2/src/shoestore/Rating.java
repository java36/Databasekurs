package shoestore;

public class Rating 
{
	private int points;
	private RatingEnum rating;
	private Customer customer;
	private Shoe shoe;
	
	public Rating(Customer customer, Shoe shoe, int points, RatingEnum rating)
	{
		this.customer = customer;
		this.shoe = shoe;
		this.points = points;
		this.rating = rating;
		
	}
	
	

	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	
	}



	public Shoe getShoe() {
		return shoe;
	}



	public void setShoe(Shoe shoe) 
	{
		this.shoe = shoe;
		

	}	

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public RatingEnum getRating() {
		return rating;
	}

	public void setRating(RatingEnum rating) {
		this.rating = rating;
	}
	
	

}
