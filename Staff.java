package main.logic;

import java.sql.SQLException;

/*import javax.persistence.Column;
import javax.persistence.Id;
*/
import main.db.db.InsertDB;

public class Staff {
	
	
	private int staffId;
	private String name;
	private String phoneNumber;
	
	int getStaffId()
	{
		return staffId;
	}
	String getName()
	{
		return name;
	}
	String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	void addStaff(String name, int staffId, String phoneNumber)
	{	
		this.name = name;
		this.staffId = staffId;
		this.phoneNumber = phoneNumber;
		
		try {
			InsertDB.addStaff(staffId, name, phoneNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
