package main.logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
//import org.hibernate.Session;
import main.db.db.DeleteDB;
//import main.db.db.FindDB;

public class Inventory 
{
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public void fetchAllItemsFromDatabase(int id) {
	    // Replace these with your actual database connection information
	    String url = "jdbc:mysql://localhost:3306/clothingstore?characterEncoding=latin1";
	    String username = "root";
	    String password = "Mysql@moeed??38";

	    // Define the SQL query to fetch all items
	    String sql = "SELECT * FROM item where id="+id;

	    try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
	        // Loop through each row in the result set
	        while (resultSet.next()) {
	            // Create a new Item object and add it to the list
	            Item item = new Item(
	                resultSet.getInt("id"),
	                resultSet.getString("name"),
	                resultSet.getString("category"),
	                resultSet.getInt("price"),
	                resultSet.getInt("count")
	            );
	            itemList.add(item);
	        }

	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	Item getItem(String name, int id) 
	{
		fetchAllItemsFromDatabase(id);
		for(int i=0; i<itemList.size(); i++)
		{
			System.out.println(itemList.size());
			Item temp = itemList.get(i);
			if(temp.itemDescription.getId() == id)
			{
				
				/*
				 * try {
				 * FindDB.findItem(temp.itemDescription.getId(),temp.itemDescription.getPrice()
				 * ,temp.itemDescription.getName(),temp.itemDescription.getCategory(),
				 * temp.itemDescription.getCount()); } catch (SQLException e){ // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
				return itemList.get(i);
			}
		}
		return null;
	}
	
	ArrayList<Item> getShortProducts() 
	{
		ArrayList<Item> namesOfShortItems = new ArrayList<Item>();
		for(int i=0; i<itemList.size(); i++)
		{
			Item temp = itemList.get(i);
			if(temp.itemDescription.getCount() <= 5)
			{
				namesOfShortItems.add(temp);
			}
		}
		return namesOfShortItems;
	}
	
	void deleteItems(String name, int id, int count) 
	{
		for(int i=0; i<itemList.size(); i++)
		{
			Item temp = itemList.get(i);
			if(temp.itemDescription.getName() == name && temp.itemDescription.getId() == id)
			{
				try {
					DeleteDB.deleteItem(temp.itemDescription.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				itemList.remove(i);
			}
		}
	}
	
	void addNewItems(String name, int id, int price, String category, int count) 
	{
		Item item = new Item();
		item.add(name,id,price,category,count);
		itemList.add(item);
	}
	
	ArrayList<Item> getProducts() 
	{
		return itemList;
	}

	/*
	 * void editItem(String name, int id, int price, int count, String category) {
	 * System.out.println("Fetching all items from the database...");
	 * 
	 * try { // Fetch all items from the database itemList = FindDB.getAllItems();
	 * 
	 * // Update the local itemList with the fetched items itemList.clear();
	 * itemList.addAll(allItems);
	 * 
	 * System.out.println("All items fetched from the database. Size: " +
	 * itemList.size());
	 * 
	 * // Now you can perform the edit operation for (Item temp : itemList) { if
	 * (temp.itemDescription.getName().equals(name) && temp.itemDescription.getId()
	 * == id) { System.out.println("Inventory edited inside the loop");
	 * temp.editItem(name, id, price, count, category); break; // Assuming there's
	 * only one item with the same name and id } } } catch (SQLException e) {
	 * e.printStackTrace(); // Handle the exception as needed } }
	 */
	void editItem(String name, int id, int price, int count, String category) 
	{
		System.out.println(itemList.size());
		
		for(int i=0; i<itemList.size(); i++)
		{
			System.out.println("for edited k andar");
			Item temp = itemList.get(i);
			if(temp.itemDescription.getName() == name && temp.itemDescription.getId() == id)
			{
				System.out.println("Inventory edited k andar");
				temp.editItem(name, id, price, count,category);
			}
		}
	}
}