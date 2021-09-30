package com.bridgelabz.JdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
	
   public static void main(String args[]) {
	   Connection con = null;
	   Statement stmt = null;
      try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      System.out.println("Driver loaded");
      }catch (Exception e) {
		System.out.println("Driver not loaded");
	}
      try{
      String url = "jdbc:mysql://localhost/customer";
      con = DriverManager.getConnection(url, "root", "password");
      System.out.println("Connection established......");
      } catch (Exception e) {
		System.out.println("Connection not established");
	}
      
      try {
      stmt = con.createStatement();
      System.out.println("Statement is ready");
      } catch (Exception e) {
		System.out.println("Statement failed");
	}
      
      try {
      String query = "CREATE TABLE CUSTOMERS("
         + "ID INT NOT NULL, "
         + "NAME VARCHAR (20) NOT NULL, "
         + "AGE INT NOT NULL, "
         + "SALARY DOUBLE (18, 2), "
         + "ADDRESS VARCHAR (250) , "
         + "PRIMARY KEY (ID))";
      stmt.execute(query);
      System.out.println("Table Created......");
      } catch (Exception e) {
		System.out.println("Table not created");
	}
   }
}