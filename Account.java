package main.logic;

import java.sql.SQLException;
//import javax.persistence.Column;
//import javax.persistence.Id;

import main.db.db.InsertDB;
import main.db.db.UpdateDB;

public class Account {

	private int userId;
	private String name;
	private String password;
	
	String getPassword()
	{
		return password;
	}
	String getName()
	{
		return name;
	}
	int getUserId()
	{
		return userId;
	}
	
	
	void regiserNewStaff(String name, int userId, String password)
	{
		this.name = name;
		this.userId = userId;
		this.password = password;
		
		try {
			InsertDB.addAccount(userId, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void updateInfo(String password)
	{
		this.password = password;
		try {
			UpdateDB.updateAccount(userId, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
