package main.logic;

public class BranchManager 
{
	private String name;
	private String phoneNumber;
	private int managerKey;
	
	int getManagerKey()
	{
		return managerKey;
	}

	public BranchManager(String name, String phoneNumber, int managerKey) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.managerKey = managerKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
