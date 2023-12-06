package main;

import main.logic.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class managerDashboardController implements Initializable {

		Alert alert;
	


		@FXML
	    private Button accountBtn;

	    @FXML
	    private AnchorPane accountForm;

	    @FXML
	    private Button account_addBtn;

	    @FXML
	    private Button account_deleteBtn;

	    @FXML
	    private TextField account_delete_userID;

	    @FXML
	    private Button account_findBtn;

	    @FXML
	    private TextField account_name;

	    @FXML
	    private TextField account_password;

	    @FXML
	    private Label account_table_id;

	    @FXML
	    private Label account_table_name;

	    @FXML
	    private Button account_updateBtn;

	    @FXML
	    private TextField account_userID;

	    @FXML
	    private Button closeBtn;

	    @FXML
	    private Button inventoryBtn;

	    @FXML
	    private AnchorPane inventoryForm;

	    @FXML
	    private Button inventory_checkBtn;

	    @FXML
	    private Button inventory_generateBtn;

	    @FXML
	    private Label inventory_item_cate1;

	    @FXML
	    private Label inventory_item_cate2;

	    @FXML
	    private Label inventory_item_cate3;

	    @FXML
	    private Label inventory_item_cate4;

	    @FXML
	    private Label inventory_item_name1;

	    @FXML
	    private Label inventory_item_name2;

	    @FXML
	    private Label inventory_item_name3;

	    @FXML
	    private Label inventory_item_name4;

	    @FXML
	    private Label inventory_item_price1;

	    @FXML
	    private Label inventory_item_price2;

	    @FXML
	    private Label inventory_item_price3;

	    @FXML
	    private Label inventory_item_price4;

	    @FXML
	    private Label inventory_shortage_count1;

	    @FXML
	    private Label inventory_shortage_count2;

	    @FXML
	    private Label inventory_shortage_count3;

	    @FXML
	    private Label inventory_shortage_name1;

	    @FXML
	    private Label inventory_shortage_name2;

	    @FXML
	    private Label inventory_shortage_name3;

	    @FXML
	    private Button salesBtn;

	    @FXML
	    private AnchorPane salesForm;

	    @FXML
	    private Label sales_avgRevenueText;

	    @FXML
	    private BarChart<String, Integer> sales_barchart;

	    @FXML
	    private Button sales_checkBtn;

	    @FXML
	    private Button sales_generateBtn;

	    @FXML
	    private Label sales_totalRevenueText;

	    @FXML
	    private Label sales_totalSalesText;

	    @FXML
	    private Button signoutBtn;

	    @FXML
	    private Button staffBtn;

	    @FXML
	    private AnchorPane staffForm;

	    @FXML
	    private Button staff_addBtn;

	    @FXML
	    private Button staff_dismissBtn;

	    @FXML
	    private TextField staff_dismiss_staffID;

	    @FXML
	    private TextField staff_name;

	    @FXML
	    private TextField staff_phoneNum;

	    @FXML
	    private TextField staff_staffID;
	    
	    @FXML
	    public void close() {
	    	alert = new Alert (AlertType. CONFIRMATION) ;
	    	alert.setTitle("Confirmation Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("Are you sure you want to Exit?") ;
	    	Optional<ButtonType> option = alert.showAndWait();
	    	
	    	if (option.get().equals(ButtonType.OK)) {
	    		System.exit(0);
	    	}
	    	
	    }
	    
	    @FXML
	    public void signOut() {
	    	try {
	    		
	    		alert = new Alert (AlertType. CONFIRMATION) ;
		    	alert.setTitle("Confirmation Message");
		    	alert. setHeaderText (null) ;
		    	alert.setContentText ("Are you sure you want to Sign Out?") ;
		    	Optional<ButtonType> option = alert.showAndWait();
		    	
		    	if (option.get().equals(ButtonType.OK)) {
					Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					
					signoutBtn.getScene().getWindow().hide();
					
					stage.setScene(scene);
					stage.show();
			    	}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    
	    //Staff Form Event Handlers
	    
	    @FXML
	    public void addStaff() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("Add staff called with values:\n" +staff_name.getText() +"\n" + staff_staffID.getText() +"\n"+ staff_phoneNum.getText()) ;
	    	alert.showAndWait();
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	ClothingStore.getInstance().addStaff( staff_name.getText(), Integer.parseInt(staff_staffID.getText()) , staff_phoneNum.getText()); 
	    	
	    	//void addStaff (String name, int id, String phoneNumber, String password) 
	    }
	    
	    @FXML
	    public void dismissStaff() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("Dismiss staff called with values:\n" +staff_dismiss_staffID.getText()) ;
	    	alert.showAndWait();
	    	
	    	// findStaff(int staffId); show this first then ask to dismiss
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	ClothingStore.getInstance().dismissStaff(Integer.parseInt(staff_dismiss_staffID.getText())); 
	    	
	    	//void dismissStaff (int staffId)
	    	
	    }
	    //Inventory Form Event Handlers

	    @FXML
	    public void generateItemsRecord() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("generateItemsRecord called ") ;
	    	alert.showAndWait();
	    	
	    	ClothingStore.getInstance().generateRecord();
	    	
	    	// Return items to inventory_itemTable
	    	
	    }
	    
	    @FXML
	    public void checkShortage() {
	    	
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("checkShortage called ") ;
	    	alert.showAndWait();
	    	
	    	ClothingStore.getInstance().notifyShortage();
	    	
	    //	ClothingStore cl = new main.logic.ClothingStore(); 
	    //	cl.notifyShortage();
	    	
	    	// Return items to inventory_shortageTable
	    }
	    
	    
	    
	    //Sales Form Event Handlers
	    
	    @FXML
	    public void generateSalesReport() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("generateSalesReport called ") ;
	    	alert.showAndWait();
	    	
	    	try {
				ClothingStore.getInstance().generateSalesReport();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	//Return items to sales_totalSalesText, sales_totalRevenueText, sales_avgRevenueText
	    	
	    }
	    
	    @FXML
	    public void checkPopularItems() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("checkShortage called ") ;
	    	alert.showAndWait();
	    	try {
				ClothingStore.getInstance().getPopularItems();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	// Return items to sales_barchart
	    
	    }
	    
	    
	    //Account Form Event Handlers

	    @FXML
	    public void addAccount() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("addAccount called with values:\n" +account_name.getText() +"\n" + account_userID.getText() +"\n"+ account_password.getText()) ;
	    	alert.showAndWait();
	    	
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	if(!account_userID.getText().isEmpty())
	    		ClothingStore.getInstance().createAccount( account_name.getText(), Integer.parseInt(account_userID.getText()) , account_password.getText()  );
	    	
	    	
	    	//	void createAccount (String name, int id, String password)

	    }
	    
	    @FXML
	    public void updateAccount() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("updateAccount called with values:\n" +account_name.getText() +"\n" + account_userID.getText() +"\n"+ account_password.getText()) ;
	    	alert.showAndWait();
	    	
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	if(!account_userID.getText().isEmpty())
	    		ClothingStore.getInstance().editAccount( account_name.getText(), Integer.parseInt(account_userID.getText()) , account_password.getText()  );
	    	
	    	
	    	//	void editAccount (String name, int id, String password)
	    	
	    }
	    
	    @FXML
	    public void findAccount() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("findAccount called with values:\n" +account_delete_userID.getText()) ;
	    	alert.showAndWait();
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	if(!account_delete_userID.getText().isEmpty())
	    		ClothingStore.getInstance().findAccount( Integer.parseInt(account_delete_userID.getText())  );
	    	
	    	
	    	//		void findAccount (int userId)

	    	
	    	//return account to account_table
	    	
	    }
	    
	    @FXML
	    public void deleteAccount() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("deleteAccount called with values:\n" +account_delete_userID.getText()) ;
	    	alert.showAndWait();
	    	
	    	// check if any to be int or Integer is not empty warna error in parsing
	    	if(!account_delete_userID.getText().isEmpty())
	    		ClothingStore.getInstance(). clearAccount(account_name.getText(), Integer.parseInt(account_delete_userID.getText())  );
	    	
	    	
	    	//			void clearAccount (String name, int userId) // remove String name from params


	    	
	    	
	    }
	    
	    @FXML
	    public void refreshAccountTable() {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("refreshAccountTable called!") ;
	    	alert.showAndWait();
	    	
	    	//refresh account_table (return all the accounts to it)
	    	
	    }
	    
	    
	    
	    public void displayBarChart(ArrayList<String> nameList, ArrayList<Integer> numOfSalesList) {
	        XYChart.Series<String, Integer> series = new XYChart.Series<>();
	        series.setName("Item");

	        for (int i = 0; i < nameList.size(); i++) {
	            series.getData().add(new XYChart.Data<>(nameList.get(i), numOfSalesList.get(i)));
	        }

	        ObservableList<XYChart.Series<String, Integer>> chartData = FXCollections.observableArrayList();
	        chartData.add(series);

	        // Clear existing data
	        sales_barchart.getData().clear();

	        // Set the data to the chart
	        sales_barchart.setData(chartData);
	    }

	    
	
	    
	    public void changeForm(ActionEvent event) {
	    	if (event.getSource() == staffBtn) {
	    		
	    		staffForm.setVisible(true);
	    		inventoryForm.setVisible(false);
	    		salesForm.setVisible(false);
	    		accountForm.setVisible(false);
	    	}
	    	else if (event.getSource() == inventoryBtn) {
	    		
	    		inventoryForm.setVisible(true);
	    		
	    		staffForm.setVisible(false);
	    		salesForm.setVisible(false);
	    		accountForm.setVisible(false);
	    	}
	    	else if (event.getSource() == salesBtn) {
	    		
	    		salesForm.setVisible(true);
	    		
	    		staffForm.setVisible(false);
	    		inventoryForm.setVisible(false);
	    		accountForm.setVisible(false);
	    	}
	    	else if (event.getSource() == accountBtn) {
	    		
	    		accountForm.setVisible(true);
	    		
	    		staffForm.setVisible(false);
	    		inventoryForm.setVisible(false);
	    		salesForm.setVisible(false);
	    	}
	    	
	    }

		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			staffForm.setVisible(true);
    		
    		inventoryForm.setVisible(false);
    		salesForm.setVisible(false);
    		accountForm.setVisible(false);
    		

    		
    		
    		
    		
    		
    	/*	
    		itemRec_col_id.setCellValueFactory(new PropertyValueFactory<ItemDescription, String>("id"));
    		itemRec_col_name.setCellValueFactory(new PropertyValueFactory<ItemDescription, Integer>("name"));
    		itemRec_col_price.setCellValueFactory(new PropertyValueFactory<ItemDescription, String>("price"));
    		itemRec_col_quantity.setCellValueFactory(new PropertyValueFactory<ItemDescription, String>("count"));
    		
    		
    		account_col_name.getColumns().addAll(null);
    		account_col_name.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));*/
		}
		
		//DOne??
		public void displayItemRecordTable(ArrayList<Integer> itemIdList, ArrayList<String> nameList, ArrayList<String> categoryList, ArrayList<Integer> quantityList, ArrayList<Integer> priceList  ) {
	    	
	    	
			inventory_item_name1.setText(nameList.get(0));;
			inventory_item_name2.setText(nameList.get(1));;
			inventory_item_name3.setText(nameList.get(2));;
			inventory_item_name4.setText(nameList.get(3));;
			
			
			inventory_item_price1.setText(Integer.toString(priceList.get(0)));;
			inventory_item_price2.setText(Integer.toString(priceList.get(1)));;
			inventory_item_price3.setText(Integer.toString(priceList.get(2)));;
			inventory_item_price4.setText(Integer.toString(priceList.get(3)));;
			
			
			inventory_item_cate1.setText(categoryList.get(0));
			inventory_item_cate2.setText(categoryList.get(1));;
			inventory_item_cate3.setText(categoryList.get(2));;
			inventory_item_cate4.setText(categoryList.get(3));;

			
	    }
		
		//DOne??
		public void displayShortageTable(ArrayList<Integer> itemIdList, ArrayList<String> nameList, ArrayList<String> categoryList, ArrayList<Integer> quantityList, ArrayList<Integer> priceList  ) {
	    	
	    	if(!nameList.isEmpty()) {
			inventory_shortage_name1.setText(nameList.get(0));;
			inventory_shortage_name2.setText(nameList.get(1));;
			inventory_shortage_name3.setText(nameList.get(2));;
			
			inventory_shortage_count1.setText(Integer.toString(quantityList.get(0)));;
			inventory_shortage_count2.setText(Integer.toString(quantityList.get(1)));;
			inventory_shortage_count3.setText(Integer.toString(quantityList.get(2)));;
	    	}
			
	    }
		
		//Done??
		public void displaySalesReport(int totalNumOfSales, int totalRevenue, int avgRevenue)
		{
		    alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Info Message");
		    alert.setHeaderText(null);
		    alert.setContentText("**Sales Report**\nTotal Sales: " + totalNumOfSales + "\nTotal Revenue: " + totalRevenue + "\nAvg Revenue: " + avgRevenue);
		    alert.showAndWait();
		}

		
		public void displayPopularItemsChart(ArrayList<String> nameList, ArrayList<Integer> numOfSalesList) {
		    XYChart.Series<String, Integer> series = new XYChart.Series<>();
		    series.setName("Item");
		    series.getData().add(new XYChart.Data<>(nameList.get(0), numOfSalesList.get(0)));
		    series.getData().add(new XYChart.Data<>(nameList.get(1), numOfSalesList.get(1)));
		    series.getData().add(new XYChart.Data<>(nameList.get(2), numOfSalesList.get(2)));

		    ObservableList<XYChart.Series<String, Integer>> chartData = FXCollections.observableArrayList();
		    chartData.add(series);

		    sales_barchart.setUserData(chartData);
		}

		
		
		//Done??
		public void displayAccountTable(Integer userId, String name, String password ) {
	    	
			
			if (userId == 0 || name.isEmpty()) {
				alert = new Alert (AlertType. ERROR) ;
		    	alert.setTitle("Error Message");
		    	alert. setHeaderText (null) ;
		    	alert.setContentText ("User Not Found!") ;
		    	alert.showAndWait();
			}
			else {
				
				alert = new Alert (AlertType. INFORMATION) ;
		    	alert.setTitle("Info Message");
		    	alert. setHeaderText (null) ;
		    	alert.setContentText ("**Account Found**\nName: " + name +"\nUser ID: "+Integer.toString(userId) ) ;
		    	alert.showAndWait();
				
				
				
				//account_table_name.setText(name);
				//account_table_id.setText(Integer.toString(userId));
				
			}
			    	
	    }
	
}
