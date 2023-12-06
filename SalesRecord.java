package main.logic;

import java.sql.SQLException;
import java.util.ArrayList;

import main.managerDashboardController;
import main.db.db.*;

public class SalesRecord 
{
	ArrayList<Sale> saleList = new ArrayList<Sale>();
	public managerDashboardController managerController = new managerDashboardController();

	void getSalesRecord() throws SQLException 
	{
		int sum = 0;
		int average = 0;
		
		saleList = FindDB.findSale();
		//System.out.println("Sale list size");
		//System.out.println(saleList.size());
		for(int i=0; i<saleList.size(); i++)
		{
			Sale temp = saleList.get(i);
			sum += temp.getAmount();
		}
		
		average = sum/saleList.size();
		
		//System.out.println("Sale report stuff avg:"+average+"sum"+sum);
		
		managerController.displaySalesReport(saleList.size(),sum,average);
		
	}
	
	/*
	 * void getPopularItems(Inventory inventory) throws SQLException { saleList =
	 * FindDB.findSale();
	 * 
	 * ArrayList<String> itemName = new ArrayList<String>(); ArrayList<Integer>
	 * itemCount = new ArrayList<Integer>(); for(int i=0;i<3;i++) {
	 * itemName.add(inventory.itemList.get(i).itemDescription.getName());
	 * itemCount.add(inventory.itemList.get(i).itemDescription.getCount()); }
	 * 
	 * //displayBarChart(itemName,itemCount); }
	 */
	void getPopularItems(Inventory inventory) throws SQLException {
	    saleList = FindDB.findSale();

	    ArrayList<String> itemName = new ArrayList<>();
	    ArrayList<Integer> itemCount = new ArrayList<>();

	    int size = Math.min(inventory.itemList.size(), 3); // Limit the loop to the smaller of 3 or the itemList size

	    for (int i = 0; i < size; i++) {
	        itemName.add(inventory.itemList.get(i).itemDescription.getName());
	        itemCount.add(inventory.itemList.get(i).itemDescription.getCount());
	    }

	    // Other logic related to popular items
	     managerController.displayPopularItemsChart(itemName,itemCount);
	}

}
