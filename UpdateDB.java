package main.db.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB 
{
	public static void updateAccount(int user_id, String name, String password) throws SQLException
	{
		String sql = "UPDATE account SET name=?, password=? WHERE user_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, name);
		statement.setString(2, password);
		statement.setString(3, Integer.toString(user_id));
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	public static void updateStaff(int staff_id, String name, String ph_num) throws SQLException  
	{
		String sql = "UPDATE staff SET name=?, ph_num=? WHERE staff_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, name);
		statement.setString(2, ph_num);
		statement.setString(3, Integer.toString(staff_id));
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing staff was updated successfully!");
		}
	}
	
	public static void updateItem(int id, int price, String name, String category, int count) throws SQLException  
	{
		String sql = "UPDATE item SET name=?, price=?, category=?, count=? WHERE id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, name);
		statement.setString(2, Integer.toString(price));
		statement.setString(3, category);
		statement.setString(4, Integer.toString(count));
		statement.setString(5, Integer.toString(id)); 
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing item was updated successfully!");
		}
	}
	
	public static void updateSale(int id, int amount, String date) throws SQLException    
	{
		String sql = "UPDATE sale SET amount=?, date=? WHERE id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, Integer.toString(amount));
		statement.setString(2, date);
		statement.setString(3, Integer.toString(id));
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing sale was updated successfully!");
		}
	}
	
	
}
