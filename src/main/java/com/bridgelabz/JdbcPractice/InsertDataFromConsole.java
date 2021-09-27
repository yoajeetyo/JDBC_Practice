package com.bridgelabz.JdbcPractice;

import java.sql.*;
import java.text.DateFormat;
import java.util.Scanner;

public class InsertDataFromConsole {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "password";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement =null;

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
			Scanner scanner = new Scanner(System.in);
			preparedStatement = connection.prepareStatement("INSERT INTO employee_payroll VALUES(?,?,?,?)");
			System.out.println("Enter ID : ");
			int id = scanner.nextInt();
			
			System.out.println("Enter Name : ");
			String name = scanner.next();
			
			System.out.println("Enter salary : ");
			double salary = scanner.nextDouble();
			
			System.out.println("Enter Start Date in the formate of YYYY-MM-DD : "); 
			String date= scanner.next();
			Date start	= Date.valueOf(date);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, salary);
			preparedStatement.setDate(4, start);
			
			int row = preparedStatement.executeUpdate();
			if (row!=0) {
				System.out.println(row);
				System.out.println("Row get inserted");
			} else {
				System.out.println("Insertion failed");
			}
			
		} catch (Exception e) {
			System.out.println("Query not executed");
		}
	}

}
