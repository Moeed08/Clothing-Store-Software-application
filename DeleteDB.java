package main.db.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDB 
{
	public static void deleteAccount(int user_id) throws SQLException
	{
		String sql = "DELETE FROM account WHERE user_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, Integer.toString(user_id));
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("An account was deleted successfully!");
		}
	}
	
	public static void deleteStaff(int staff_id) throws SQLException
	{
		String sql = "DELETE FROM staff WHERE staff_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, Integer.toString(staff_id));
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A staff was deleted successfully!");
		}
	}
	
	public static void deleteItem(int id) throws SQLException
	{
		String sql = "DELETE FROM item WHERE id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, Integer.toString(id));
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("An item was deleted successfully!");
		}
	}
	
	public static void deleteSale(int id) throws SQLException
	{
		String sql = "DELETE FROM sale WHERE id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		
		statement.setString(1, Integer.toString(id));
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A sale was deleted successfully!");
		}
	}
	
	
}
