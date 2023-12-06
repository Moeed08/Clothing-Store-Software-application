package main.db.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLCon {

	public static Connection myConn;
	
	public static void dbConnect()  {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/clothingstore?characterEncoding=latin1";
		String user = "root";
		String pass = "Mysql@moeed??38"; 
		
		try {			
			System.out.println("Connecting to database: " + jdbcUrl);

			 myConn = DriverManager. getConnection(jdbcUrl,user,pass);
			System.out.println("Connection success!");
		}
		catch (Exception exc) {
			exc. printStackTrace() ;
		}	
	}
}
