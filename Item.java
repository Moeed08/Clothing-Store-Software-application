package main.logic;

public class Item 
{
	ItemDescription itemDescription=new ItemDescription();
	
	public Item()
	{
	
	}
	public Item(Integer id, String name, String category, Integer count, Integer price) 
	{
		itemDescription.setItemDescription(id, name, category, count, price);
		// TODO Auto-generated constructor stub
	}
	void add(String name, int id, int price, String category, int count) 
	{
		itemDescription.addDetails(name,id,price,category,count);
	}
	void editItem(String name, int id, int price, int count, String category)
	{
		System.out.println("Item edited k andar");
		itemDescription.updateInfo(id,name,price,count,category);
	}	
}
