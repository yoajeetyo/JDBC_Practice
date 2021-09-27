package com.bridgelabz.JdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class GetMetadata {
	public static void main(String args[]){  
		try{  
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service?user=root&password=password");  
		  
		PreparedStatement ps=con.prepareStatement("select * from employee_payroll");  
		ResultSet rs=ps.executeQuery();  
		ResultSetMetaData rsmd=rs.getMetaData();  
		  
		System.out.println("Total columns: "+rsmd.getColumnCount());  
		System.out.println();
		System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
		System.out.println("Column Type of 1st column: "+rsmd.getColumnTypeName(1));  
		System.out.println();
		System.out.println("Column Name of 2nd column: "+rsmd.getColumnName(2));  
		System.out.println("Column Type of 2nd column: "+rsmd.getColumnTypeName(2));  
		System.out.println();
		System.out.println("Column Name of 3rd column: "+rsmd.getColumnName(3));  
		System.out.println("Column Type of 3rd column: "+rsmd.getColumnTypeName(3));  
		System.out.println();
		System.out.println("Column Name of 4th column: "+rsmd.getColumnName(4));  
		System.out.println("Column Type of 1st column: "+rsmd.getColumnTypeName(4));  
		  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
}