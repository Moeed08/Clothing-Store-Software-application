package main.logic;

/*import javax.persistence.Column;
import javax.persistence.Id;*/

public class Sale 
{
	private int id;
	private int amount;
	private String date;
	
	int getId()
	{
		return id;
	}
	int getAmount()
	{
		return amount;
	}
	String getDate()
	{
		return date;
	}
	
	void save() {}
	
	
	public Sale(int id, int amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		
		
		
	};
	
	
}
