package com.jdbc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class Jdbc01 {	
		
	 static Connection connection=null;
	 static Statement statement =null;
	 static ResultSet rs =null;
	 static {
	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	  } catch (ClassNotFoundException e) {
	  
	   e.printStackTrace();
	  } 
	 }

	 public static void main(String[] args) throws SQLException {
	
	  String query=null;
	  try {
	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","");
	   statement= connection.createStatement();   
	 
	   query="select * from students";
	   rs = statement.executeQuery(query);
	   while(rs.next())
	   {
	    
	    System.out.println(rs.getInt(1) +", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4));
	   }
	  } 
	  catch (SQLException e) {
	  
	   e.printStackTrace();
	  }
	  finally {
	   rs.close();
	   statement.close();
	   connection.close();
	  } 
	   
	  System.out.println("COMPLETED");
	 }

	}


