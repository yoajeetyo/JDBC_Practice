package com.bridgelabz.JdbcPractice;

import java.sql.*;
import java.text.DateFormat;
import java.util.Scanner;

public class GettingMetaDataWithoutKnowing {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/customer?useSSL=false";
		String userName = "root";
		String password = "password";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!!!");
		} catch (Exception e) {
			System.out.println("Driver not loaded!!");
		}
		
		try {
			connection = DriverManager.getConnection(jdbcUrl,userName,password);
			System.out.println("Connection established successfullyy !!!!!!!");
		} catch (Exception e) {
			System.out.println("Connection not established!!");
		}
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM customers");
			resultSetMetaData = resultSet.getMetaData();
			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
				System.out.println(resultSetMetaData.getColumnName(i)+"    "+resultSetMetaData.getColumnTypeName(i));
			}
			
		} catch (Exception e) {
			System.out.println("Query not executed");
		}
	}

}