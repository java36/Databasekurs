package shoestore;

public class Shoe 
{
	private int id;
	private String brand;
	private String model;
	private int size;
	private String colour;
	private double price;
	private int inStock;
	
	public Shoe(int id, String brand, String model, int size, String colour, double price, int inStock)
	{
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.size = size;
		this.colour = colour;
		this.price = price;
		this.inStock = inStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	

}
