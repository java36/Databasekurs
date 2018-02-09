package shoestore;

import java.sql.Date;
import java.sql.Time;

public class Order 
{
	private int id;
	private Date date;
	private Time time;
	private Customer customer;
	private boolean executed;
	
	

	public Order(int id, Date date, Time time, Customer customer, boolean executed)
	{
		this.id = id;
		this.date = date;
		this.time = time;
		this.customer = customer;
		this.executed = executed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	
}
