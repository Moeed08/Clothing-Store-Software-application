package main;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.logic.ClothingStore;

public class LoginController {

	Alert alert;
    @FXML
    private Button closeBtn;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField managerKey;

    @FXML
    private Button managerLoginBtn;

    @FXML
    private AnchorPane managerPane;

    @FXML
    private PasswordField password;

    @FXML
    private Button staffLoginBtn;

    @FXML
    private AnchorPane staffPane;

    @FXML
    private TextField userID;
    
   
    
    
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
    
    public void loginStaff() {
    	if (userID.getText().isBlank() || password.getText().isBlank() ) {
    		alert = new Alert (AlertType. ERROR) ;
        	alert.setTitle("Error");
        	alert. setHeaderText (null) ;
        	alert.setContentText ("Please enter the User ID and Password!") ;
        	alert.showAndWait();
    	}
    	else {
    		System.out.println( userID.getText() + "logged in!");
        	System.out.println( password.getText() + "logged in!");
        	
        	System.out.println("Staff login\n");
	    	
        	//Check if staff account exists // business logic will be invoked
        	
	    	Boolean loginSuccessful = ClothingStore.getInstance().IoginStaff(Integer.parseInt(userID.getText()) ,password.getText());
	    	System.out.print(loginSuccessful);
	    	if (loginSuccessful) {
	    		try {
					Parent root = (Parent) FXMLLoader.load(getClass().getResource("/main/StaffDashboard.fxml"))  ;
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					
					staffLoginBtn.getScene().getWindow().hide();
					
					stage.setScene(scene);
					stage.show();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	else {
	    		alert = new Alert (AlertType. ERROR) ;
	        	alert.setTitle("Error");
	        	alert. setHeaderText (null) ;
	        	alert.setContentText ("Incorrect Staff Key!") ;
	        	alert.showAndWait();
	    	}
    	}
    }
    
    public void loginManager() {
    	
    	if (managerKey.getText().isBlank() ) {
    		alert = new Alert (AlertType. ERROR) ;
        	alert.setTitle("Error");
        	alert. setHeaderText (null) ;
        	alert.setContentText ("Please enter the Manager Key!") ;
        	alert.showAndWait();
    	}
    	else {
	    	System.out.println( managerKey.getText() + "logged in!");
	    	
        	//Check if Manager key is correct // business logic will be invoked
	    	
	    	Boolean loginSuccessful = ClothingStore.getInstance().IoginManager(Integer.parseInt(managerKey.getText()));;
	    	
	    	if (loginSuccessful) {
	    		try {
					Parent root = (Parent) FXMLLoader.load(getClass().getResource("/main/ManagerDashboard.fxml"))  ;
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					
					managerLoginBtn.getScene().getWindow().hide();
					
					stage.setScene(scene);
					stage.show();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	else {
	    		alert = new Alert (AlertType. ERROR) ;
	        	alert.setTitle("Error");
	        	alert. setHeaderText (null) ;
	        	alert.setContentText ("Incorrect Manager Key!") ;
	        	alert.showAndWait();
	    	}
    	}
    	
    }
    

}




