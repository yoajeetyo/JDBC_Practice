package com.bridgelabz.JdbcPractice;

import java.sql.*;
import java.util.Enumeration;


public class GettingAllDataFromCustomersTable {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/customer?useSSL=false";
		String userName = "root";
		String password = "password";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded!");
			
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot found the driver in the class path!", e);
		}
		listDrivers();
		
		try {
			System.out.println("Connecting to database : "+jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
			System.out.println("Connection is successful !!!!!!!"+connection);
			
			Statement statement = connection.createStatement();
			System.out.println("Statement ready!!!");
			ResultSet result =  statement.executeQuery("Select * from customers");
			System.out.println("Your Query Result is : ");
			while (result.next()) {
				System.out.println(result.getInt("Id")+"  "+result.getString("name")+"  "+result.getInt("age")+"  "+result.getDouble("salary")+"  "+result.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
			
		}
	}
}