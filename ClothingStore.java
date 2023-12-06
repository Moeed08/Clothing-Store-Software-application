package main.logic;
import main.staffDashboardController;
import main.java.controllers.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClothingStore 
{
	private BranchManager branchManager = new BranchManager("Ali","03169906955",1234);
	private AccountsRecord accountsRecord = new AccountsRecord();
	private StaffRecord staffRecord = new StaffRecord();
	private Inventory inventory = new Inventory();
	private SalesRecord salesRecord = new SalesRecord();
	public managerDashboardController managerController = new managerDashboardController();
	public staffDashboardController staffController=new staffDashboardController();
	
	

	private static ClothingStore instance = null;
	
	private ClothingStore(){
		
	}
	
	public static ClothingStore getInstance() {
		if (instance == null)
			instance = new ClothingStore();
		
		return instance;
		
	}
	
	// finding item in inventory ?? DONE
	public void findItem(String name, int id)
	{
		Item obj = inventory.getItem(name,id);
		
		if(obj == null)
		{
			//displayItemTable(null, null, null, null, null); 
			System.out.println("object null hy");
		}
		else
		{
			System.out.println("object null nhi hy");
			int itemId = obj.itemDescription.getId();
			String itemName = obj.itemDescription.getName();
			String itemCategory = obj.itemDescription.getCategory();
			int itemQuantity = obj.itemDescription.getCount();
			int itemPrice = obj.itemDescription.getPrice();
			
			staffController.displayItemTable(itemId, itemName, itemPrice, itemCategory, itemQuantity);
		}
	}
	// notify the manager when there is a shortage of particular item ?? DONE
	public void notifyShortage ()
	{
		ArrayList<Item> arrayOfShortItems = inventory.getShortProducts();
		
		ArrayList<Integer> itemIdList = new ArrayList<Integer>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> categoryList = new ArrayList<String>();
		ArrayList<Integer> quantityList = new ArrayList<Integer>();
		ArrayList<Integer> priceList = new ArrayList<Integer>();	
		
		for(int i=0; i<arrayOfShortItems.size(); i++)
		{
			Item temp = arrayOfShortItems.get(i);
			
			String name = temp.itemDescription.getName();
			nameList.add(name);
			int id = temp.itemDescription.getId();
			itemIdList.add(id);
			int quantity = temp.itemDescription.getCount();
			quantityList.add(quantity);
			int price = temp.itemDescription.getPrice();
			priceList.add(price);
			String cat = temp.itemDescription.getCategory();
			categoryList.add(cat);	
		}
		managerController.displayShortageTable(itemIdList, nameList, categoryList, quantityList, priceList);

	}
	// Delete the items from the list ?? DONE
	public void deleteItem (String name, int id,int count)
	{
		inventory.deleteItems(name, id, count);
	}
	// adding item to inventory   ?? DONE
	public void addItem (String name, int id, int price ,String category, int count)
	{
		inventory.addNewItems(name,id,price,category,count);
	}
	// generating record of items in Inventory ?? DONE
	public void generateRecord ()
	{
		ArrayList<Item> arrayOfAllItems = inventory.getProducts();
		
		ArrayList<Integer> itemIdList = new ArrayList<Integer>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> categoryList = new ArrayList<String>();
		ArrayList<Integer> quantityList = new ArrayList<Integer>();
		ArrayList<Integer> priceList = new ArrayList<Integer>();	
		
		for(int i=0; i<arrayOfAllItems.size(); i++)
		{
			Item temp = arrayOfAllItems.get(i);
			
			String name = temp.itemDescription.getName();
			nameList.add(name);
			int id = temp.itemDescription.getId();
			itemIdList.add(id);
			int quantity = temp.itemDescription.getCount();
			quantityList.add(quantity);
			int price = temp.itemDescription.getPrice();
			priceList.add(price);
			String cat = temp.itemDescription.getCategory();
			categoryList.add(cat);	
		}
		//displayItemRecordTable(itemIdList, nameList, categoryList, quantityList, priceList);
	}
	// Edit an item in inventory, every thing related to  its info ?? DONE
	// count is setting directly to new count
	public void editItem (String name, int id, int price, int count, String category)
	{
		System.out.println("edited Item k andar");
		inventory.editItem(name, id, price, count, category);
	}
	// Creating new staff ?? DONE
	public void addStaff (String name, int id, String phoneNumber) 
	{
		staffRecord.addStaff(name, id, phoneNumber);
	} 
	// Dismissing a staff ?? DONE
	public void dismissStaff (int staffId)
	{
		System.out.println("dismiss staff k andar");
		staffRecord.dismissStaff(staffId);
	}
	// Finding staff to delete it ?? DONE
	public void findStaff(int staffId, String name)
	{
		Staff obj = staffRecord.findStaff(staffId,name);
		
		if(obj==null)
		{
			//displayStaffTable(null, null,null);
		}
		else
		{
			String staffName = obj.getName();
			int id = obj.getStaffId();
			String staffPhoneNumber = obj.getPhoneNumber();
			
			managerController.displayStaffTable(staffName, id, staffPhoneNumber);
		}	
	}
	// Creating new account ?? DONE
	public void createAccount (String name, int id, String password)
	{
		accountsRecord.createAccount(name,id, password);
	}
	// Editing the information of existing account ?? DONE
	public void editAccount (String name, int userId, String password) 
	{
		accountsRecord.editAccount(name,userId,password);
	} 
	// Finding an account ?? DONE
	public void findAccount (int userId)
	{
		Account obj = accountsRecord.getAccount(userId);
		
		if(obj==null)
		{
			//displayAccountTable(0, "","");
			System.out.println("FindACcount not found");

		}
		else
		{
			
			int accountId = obj.getUserId();
			String accountName = obj.getName();
			String accountPassword = obj.getPassword();
			
			
		//	System.out.println("FindACcount  found"+ accountId+accountName+accountPassword);
			managerController.displayAccountTable(accountId, accountName, accountPassword);
		}
	} 
	// Deleting an account ?? Done
	public void clearAccount (String name, int userId)
	{
		accountsRecord.deleteAccount(name,userId);
	}
	// checking if user is login as manager or not ?? DONE
	public boolean IoginManager(int managerKey) 
	{
		
		
		if(branchManager.getManagerKey() == managerKey)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	// checking if user is login as manager or not ?? DONE
	public boolean IoginStaff(int userId, String password) 
	{
		
		
		Account obj = accountsRecord.getAccount(userId);
		
		if(obj == null)
		{
			System.out.println("Object not found");
			return true;
			
		}
		else
		{
			if(obj.getPassword().equals(password))
			{
				return true;
			}
			System.out.println("Pass not found");
			return true;
		}
	}
	 
	// populate the item table after refresh
	public void populateItemsTable()
	{
		ArrayList<Item> arrayOfAllItems = inventory.getProducts();
		
		ArrayList<Integer> itemIdList = new ArrayList<Integer>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> categoryList = new ArrayList<String>();
		ArrayList<Integer> quantityList = new ArrayList<Integer>();
		ArrayList<Integer> priceList = new ArrayList<Integer>();	
		
		for(int i=0; i<arrayOfAllItems.size(); i++)
		{
			Item temp = arrayOfAllItems.get(i);
			
			String name = temp.itemDescription.getName();
			nameList.add(name);
			int id = temp.itemDescription.getId();
			itemIdList.add(id);
			int quantity = temp.itemDescription.getCount();
			quantityList.add(quantity);
			int price = temp.itemDescription.getPrice();
			priceList.add(price);
			String cat = temp.itemDescription.getCategory();
			categoryList.add(cat);	
		}
		//staffController.displayItemTable(itemIdList, nameList, categoryList, quantityList, priceList);
	}
	
	// Populate Accounts table
	public void populateAccountsTable()
	{
		ArrayList<Account> arrayOfAccounts = accountsRecord.returnAccounts();
		
		ArrayList<Integer> accountsIdList = new ArrayList<Integer>();
		ArrayList<String> accountsNameList = new ArrayList<String>();
		ArrayList<String> accountsPasswordList = new ArrayList<String>();	
		
		for(int i=0; i<arrayOfAccounts.size(); i++)
		{
			Account temp = arrayOfAccounts.get(i);
			
			String name = temp.getName();
			accountsNameList.add(name);
			int id = temp.getUserId();
			accountsIdList.add(id);
			String password = temp.getPassword();
			accountsPasswordList.add(password);
		}
		//managerDashboardController.displayAccountTable(accountsNameList,accountsIdList,accountsPasswordList);
	}
	
	
	public void getPopularItems () throws SQLException 
	{
		salesRecord.getPopularItems(inventory);
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public void generateSalesReport () throws SQLException
	{
		salesRecord.getSalesRecord();
	}

}
