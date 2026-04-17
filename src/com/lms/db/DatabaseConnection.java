package com.lms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
		
		public static Connection getConnection() throws ClassNotFoundException{
		//#STEP-1 : REGISTER THE DRIVER:
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//#STEP-2 : Establish the connection:
			
			
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","root");
				return con;
			
			
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
	
		}
}