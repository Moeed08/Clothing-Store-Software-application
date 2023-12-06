package main.logic;

import java.sql.SQLException;

//import javax.persistence.Column;
//import javax.persistence.Id;

import main.db.db.InsertDB;
import main.db.db.UpdateDB;

public class ItemDescription 
{
	private int id;
	private int price;
	private String name;
	private String category;
	private int itemCount = 0;
	
	int getId()
	{
		return id;
	}
	int getPrice()
	{
		return price;
	}
	String getName()
	{
		return name;
	}
	String getCategory()
	{
		return category;
	}
	int getCount()
	{
		return itemCount;
	}
	void setId(int id)
	{
		this.id=id;
	}
	void setPrice(int  price)
	{
		this.price=price;
	}
	void setCategory(String  category)
	{
		this.category=category;
	}
	void setName(String  name)
	{
		this.name=name;
	}
	void setCount(int count)
	{
		this.itemCount=count;
	}
	void setItemDescription(Integer id,String name,String category,Integer itemCount,Integer price)
	{
		this.id=id;
		this.price=price;
		this.name=name;
		this.category=category;
		this.itemCount=itemCount;
	}
	void addDetails(String name, int id, int price, String category, int count) 
	{
		this.category = category;
		this.id = id;
		this.name = name;
		this.price = price;
		
		if(this.itemCount == 0)
		{
			this.itemCount = count;
		}
		else
		{
			this.itemCount += count;
		}	
		
		try {
			InsertDB.addItem(id, price, name, category, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void updateInfo(int id,String name,int price, int count, String category) 
	{
		this.price = price;
		itemCount = count;
		this.category = category;
		this.id=id;
		this.name=name;
		
		try {
			System.out.println("Update info edited k andar");
			UpdateDB.updateItem(id, price, name, category, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
