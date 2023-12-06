package main.db.db;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import main.logic.Item;
import main.logic.Sale;

public class FindDB 
{
	public static void findAccount(int user_id, String name, String password) throws SQLException
	{
		String sql = "SELECT * FROM account WHERE user_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		while (result.next()){
		    String name1 = result.getString(2);
		    String pass = result.getString(3);
		  
		    String output = "User #%d: %s - %s";
		    System.out.println(String.format(output, ++count, name1, pass));
		}
	}
	
	public static void findAccount(int user_id) throws SQLException
	{
		String sql = "SELECT * FROM account WHERE user_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		while (result.next()){
		    String name1 = result.getString(2);
		    String pass = result.getString(3);
		  
		    String output = "User #%d: %s - %s";
		    System.out.println(String.format(output, ++count, name1, pass));
		}
	}
	
	public static void findStaff(int staff_id, String name, String ph_num) throws SQLException
	{
		String sql = "SELECT * FROM staff WHERE staff_id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		while (result.next()){
		    String name1 = result.getString(2);
		    String ph_num1 = result.getString(3);
		  
		    String output = "User #%d: %s - %s";
		    System.out.println(String.format(output, ++count, name1, ph_num1));
		}
	}
	
	public static void findItem(int id, int price, String name, String category, int count) throws SQLException
	{
		String sql = "SELECT * FROM item WHERE id=?";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		 
		//int count1 = 0;
		while (result.next()){
		    String name1 = result.getString(2);
		    int price1 = Integer.parseInt(result.getString(3));
		    String cat = result.getString(4);
		    int count11 = Integer.parseInt(result.getString(5));
		    
		    String output = "User #%d: %d - %s - %s - %d";
		    System.out.println(String.format(output, ++count11, name1, price1, cat, count11));
		}
	}
	
	public static ArrayList<Sale> findSale() throws SQLException
	{
		String sql = "SELECT * FROM sale";
		 
		PreparedStatement statement;
		statement = MySQLCon.myConn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		
		ArrayList<Sale> dbSale = new ArrayList<Sale>(); 
		 
		int count = 0;
		while (result.next()){
			
			int id1 = Integer.parseInt(result.getString(1));
		    int amount1 = Integer.parseInt(result.getString(2));
		    String date1 = result.getString(3);
		    
		    dbSale.add(new Sale(id1,amount1,date1));
		  
		    String output = "User #%d: %s - %s";
		    System.out.println(String.format(output, ++count, amount1, date1));
		    //System.out.println(dbSale.size());
		}
		
		return dbSale;
	}
}

/*
 * public static ArrayList<Item> getAllItems() {
 * 
 * String sql = "SELECT * FROM item"; ArrayList<Item> allItems = new
 * ArrayList<>(); PreparedStatement statement; statement =
 * MySQLCon.myConn.prepareStatement(sql); ResultSet result =
 * statement.executeQuery(sql); while (result.next()) { // Create and add an
 * Item for each row in the result set allItems.add(new Item(result)); }
 * 
 * 
 * return allItems;
 * 
 * }
 */
	
