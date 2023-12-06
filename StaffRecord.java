package main.logic;
import java.sql.SQLException;
import java.util.ArrayList;

//import org.hibernate.Session;
import main.db.db.DeleteDB;
import main.db.db.FindDB;

public class StaffRecord 
{
	ArrayList<Staff> staffList = new ArrayList<Staff>(); 
			
	Staff findStaff(int staffId, String name)
	{
		for(int i=0; i<staffList.size(); i++)
		{
			Staff temp = staffList.get(i);
			if(temp.getName() == name && temp.getStaffId() == staffId)
			{
			try {
					FindDB.findStaff(temp.getStaffId(),temp.getName(),temp.getPhoneNumber());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				return staffList.get(i);
			}
		}
		return null;
	}
	
	void dismissStaff(int staffId)
	{
		//System.out.println(staffList.size());
		
		for(int i=0; i<staffList.size(); i++)
		{
			
			System.out.println(staffList.size());
			Staff temp = staffList.get(i);
			if(temp.getStaffId() == staffId)
			{
				try {
					DeleteDB.deleteStaff(staffId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				staffList.remove(i);
			}
		}
		try {
			DeleteDB.deleteStaff(staffId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void addStaff(String name, int id, String phoneNumber)
	{
		Staff staff = new Staff();
		staff.addStaff(name, id, phoneNumber);
		staffList.add(staff);
	}
}
