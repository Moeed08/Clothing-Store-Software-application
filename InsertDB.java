package main.db.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDB {
	
	public static void addStaff(int staff_id, String name, String ph_num) throws SQLException  
	{	
		String sql = "INSERT INTO staff (staff_id, name, ph_num) VALUES (?,?,?)";
		
		PreparedStatement statement;
	
			statement = MySQLCon.myConn.prepareStatement(sql);
			statement.setString(1, Integer.toString(staff_id));
			statement.setString(2, name);
			statement.setString(3, ph_num);
			
			int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0) 
		{
		    System.out.println("A new staff was inserted successfully!");
		}
	}	
	
	
	public static void addAccount(int user_id, String name, String password) throws SQLException  
	{	
		String sql = "INSERT INTO account (user_id,name,password) VALUES (?,?,?)";
		
		PreparedStatement statement;
	
		statement = MySQLCon.myConn.prepareStatement(sql);
		statement.setString(1, Integer.toString(user_id));
		statement.setString(2, name);
		statement.setString(3, password);
			
			int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0) 
		{
		    System.out.println("A new account was inserted successfully!");
		}
	}
	
	public static void addSale(int id, int amount, String date) throws SQLException  
	{	
		String sql = "INSERT INTO sale (id,amount,date) VALUES (?,?,?)";
		
		PreparedStatement statement;
	
			statement = MySQLCon.myConn.prepareStatement(sql);
			statement.setString(1, Integer.toString(id));
			statement.setString(2, Integer.toString(amount));
			statement.setString(3, date);
			
			int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0) 
		{
		    System.out.println("A new sale was inserted successfully!");
		}
	}
	
	public static void addItem(int id, int price, String name, String category, int count) throws SQLException  
	{	
		String sql = "INSERT INTO item (id,name,price,category,count) VALUES (?,?,?,?,?)";
		
		PreparedStatement statement;
	
			statement = MySQLCon.myConn.prepareStatement(sql);
			statement.setString(1, Integer.toString(id));
			statement.setString(2, name);
			statement.setString(3, Integer.toString(price));
			statement.setString(4, category);
			statement.setString(5, Integer.toString(count));
			
			int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0) {
		    System.out.println("A new item was inserted successfully!");
		}
	}	
}
