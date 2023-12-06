package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.logic.ClothingStore;
import main.logic.Item;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;


public class staffDashboardController implements Initializable{

	Alert alert;
	 @FXML
	 private Button account_refreshBtn;

	    @FXML
	    private Button addBtn;

	    @FXML
	    private TextField category;

	    @FXML
	    private Button deleteBtn;

	    @FXML
	    private TextField delete_itemID;

	    @FXML
	    private Button findBtn;

	    @FXML
	    private TextField itemID;

	    @FXML
	    private TableView<?> itemTable;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextField price;
	    
	    @FXML
	    private TextField count;

	    @FXML
	    private Button signoutBtn;
	    
	    @FXML
	    private AnchorPane leftPane;
	    
	    @FXML
	    private AnchorPane rightPane;
	    
	    @FXML
	    private AnchorPane topPane;

	    @FXML
	    private Button updateBtn;
	    
	    @FXML
	    private Button closeBtn;
	    
	    @FXML 
	    private TableColumn<Item,Integer> itemIdColumn;
	    
	    @FXML 
	    private TableColumn<Item,String> nameColumn;
	    
	    @FXML 
	    private TableColumn<Item,String> categoryColumn;
	    
	    @FXML 
	    private TableColumn<Item,Integer> quantityColumn;
	    
	    @FXML 
	    private TableColumn<Item,Integer> priceColumn;
	    
	    @FXML
	    private TableView<Item> itemTableView;
	    
	    ObservableList<Item> items = FXCollections.observableArrayList();
	    public void initialize(URL arg0, ResourceBundle arg1) 
	    {
	    	
	    	 // Assuming you have appropriate getters in the Item class
		    itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
		    nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		    priceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
		    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
		    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));

		}
	    
	    
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
	    public void addItem(ActionEvent event) {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("addItem called with values:\n" +name.getText() +"\n" + itemID.getText() +"\n"+ category.getText()+"\n"+ price.getText() +"\n"+ count.getText());
	    	alert.showAndWait();
	    	// check if any to be int or double is not empty warna error in parsing
	    	
	    	   System.out.println("If condition chal rhi hy");	
	    	   ClothingStore.getInstance().addItem( name.getText(), Integer.parseInt(itemID.getText()) , Integer. parseInt(price.getText()) , category.getText() , Integer.parseInt(count.getText()) );
				/*
				 * } else System.out.println("If condition nhi chali");
				 */
	    	
	    }
	    
	    
	    @FXML
	    public void updateItem(ActionEvent event) {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("updateItem called with values:\n" +name.getText() +"\n" + itemID.getText() +"\n"+ category.getText()+"\n"+ price.getText() +"\n"+ count.getText()) ;
	    	alert.showAndWait();
	    	
	    	// check if any to be int or double is not empty warna error in parsing
	    	if(!delete_itemID.getText().isEmpty() && !price.getText().isEmpty() && !count.getText().isEmpty())
	    	{
	    		System.out.println("if chal rhi hy");
	    		ClothingStore.getInstance().editItem( name.getText(), Integer.parseInt(itemID.getText()) , Integer. parseInt(price.getText()) , Integer.parseInt(count.getText()), category.getText()  );
	    
	    	}
	    	else
	    	{
	    		System.out.println("else chal rhi hy");
	    		ClothingStore.getInstance().editItem( name.getText(), Integer.parseInt(itemID.getText()) , Integer. parseInt(price.getText()) , Integer.parseInt(count.getText()), category.getText()  );

	    	}// editItem function missing category
	    }


	    @FXML
	    public void deleteItem(ActionEvent event) {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("deleteItem called with values:\n" +delete_itemID.getText()) ;
	    	alert.showAndWait();
	    	
	    	
	    	// check if any to be int or double is not empty warna error in parsing
	    	if(!delete_itemID.getText().isEmpty())
	    		ClothingStore.getInstance().deleteItem("", Integer.parseInt(delete_itemID.getText()),0);
	    	
	    	
	    }

	    @FXML
	    public void findItem(ActionEvent event) {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("findItem called with values:\n" +delete_itemID.getText()) ;
	    	alert.showAndWait();
	    	
	    	// check if any to be int or double is not empty warna error in parsing
	    	if(!delete_itemID.getText().isEmpty())
	    		ClothingStore.getInstance(). findItem( "",Integer.parseInt(delete_itemID.getText()));
	    	
	    	//return found item to itemTable
	    }

	    @FXML
	    public void refreshItemTable(ActionEvent event) {
	    	alert = new Alert (AlertType. INFORMATION) ;
	    	alert.setTitle("Info Message");
	    	alert. setHeaderText (null) ;
	    	alert.setContentText ("Refresh called with values:\n" +itemID.getText()) ;
	    	alert.showAndWait();
	    	
	    	//return all items to itemTable
	    }

	    @FXML
	    public void signOut(ActionEvent event) {
	    	try {
	    		
	    		alert = new Alert (AlertType. CONFIRMATION) ;
		    	alert.setTitle("Confirmation Message");
		    	alert. setHeaderText (null) ;
		    	alert.setContentText ("Are you sure you want to Sign Out?") ;
		    	Optional<ButtonType> option = alert.showAndWait();
		    	
		    	if (option.get().equals(ButtonType.OK)) {
					Parent root = FXMLLoader.load(getClass().getResource("/main/Login.fxml"));
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
	    
	    
	    
	    public void displayItemTable(ArrayList<Integer> itemIdList, ArrayList<String> nameList,
	            ArrayList<String> categoryList, ArrayList<Integer> quantityList, ArrayList<Integer> priceList) 
	    {

	        // Create an ObservableList to hold the items
	        ObservableList<Item> items = FXCollections.observableArrayList();

	        // Populate the ObservableList with Item objects
	        for (int i = 0; i < itemIdList.size(); i++) 
	        {
	            Item item = new Item(itemIdList.get(i), nameList.get(i), categoryList.get(i), quantityList.get(i),
	                    priceList.get(i));
	            items.add(item);
	        }
	        itemTableView.setItems(items);
	    }


		public void displayItemTable(int itemId, String itemName, int itemPrice, String itemCategory,int itemQuantity) 
		{
			
			Item newItem = new Item(itemId, itemName, itemCategory, itemQuantity, itemPrice);
		    // Add the new item to the table
		    itemTableView.getItems().add(newItem);
			
		}

	  

}
