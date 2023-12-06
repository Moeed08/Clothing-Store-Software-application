package main;
	
import main.db.db.*; 
//import main.logic.*;
//import java.io.FileInputStream;

//import java.lang.Throwable.*;
//import java.sql.SQLException;

/*import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/*blue #0c6fa6
grey #343a40
white #fefefe
red # dc3545*/

public class Main extends Application {
	
	//@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("Login.fxml"))  ;
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MySQLCon.dbConnect();
		launch(args);
	}
}
