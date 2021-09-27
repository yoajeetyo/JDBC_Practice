package com.bridgelabz.JdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER_ID = "root";
   static final String PASSWORD = "password";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);
         Statement stmt = conn.createStatement();
      ) {		      
         String db = "CREATE DATABASE customer";
         stmt.executeUpdate(db);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}