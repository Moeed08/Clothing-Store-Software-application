package main.logic;
import java.sql.SQLException;
import java.util.ArrayList;

//import org.hibernate.Session;

import main.db.db.DeleteDB;
import main.db.db.FindDB;
import main.db.db.UpdateDB;
//import main.db.db.FindDB;
//import main.db.db.*;
public class AccountsRecord 
{
	ArrayList<Account> accountsList = new ArrayList<Account>();
	
	void editAccount(String name, int userId, String password)
	{
		
		 for(int i=0; i<accountsList.size(); i++) {
		 Account temp = accountsList.get(i); if(temp.getName() == name &&
		 temp.getUserId() == userId) { temp.updateInfo(password); }
		  temp.updateInfo(password); }
		 
		try {
			UpdateDB.updateAccount(userId, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	Account getAccount(int userId)
	{
		for(int i=0; i<accountsList.size(); i++)
		{
			Account temp = accountsList.get(i);

			if(temp.getUserId() == userId)
			{
				try {
				FindDB.findAccount(temp.getUserId(), temp.getName(), temp.getPassword());
				System.out.print(temp.getPassword());
				System.out.print(temp.getUserId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				return accountsList.get(i);
			}
		}
		try {
			FindDB.findAccount(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	void deleteAccount(String name, int userId)
	{
		for(int i=0; i<accountsList.size(); i++)
		{
			Account temp = accountsList.get(i);
			if(temp.getUserId() == userId && temp.getName() == name)
			{
				try {
					DeleteDB.deleteAccount(temp.getUserId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accountsList.remove(i);
			}
		}
	}
		
	void createAccount(String name, int userId, String password)
	{
		Account accounts = new Account();
		accounts.regiserNewStaff(name,userId,password);
		accountsList.add(accounts);
	}
	
	ArrayList<Account> returnAccounts()
	{
		return accountsList;
	}
	
}
