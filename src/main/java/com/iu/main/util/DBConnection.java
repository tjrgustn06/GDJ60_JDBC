package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	
	
	public void getConnection() throws Exception {
		//1. ID
		String username = "hr";
		//2.Pw
		String Password = "hr";
		//3.url
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4.driver 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, Password);
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("EMPLOYEE_ID"));
			System.out.println(rs.getString("FIRST_NAME"));
			System.out.println(rs.getString("LAST_NAME"));
			System.out.println(rs.getString("EMAIL"));
			System.out.println(rs.getString("PHONE_NUMBER"));
			System.out.println(rs.getDate("HIRE_DATE"));
			System.out.println(rs.getString("JOB_ID"));
			System.out.println(rs.getInt("SALARY"));
			System.out.println(rs.getDouble("COMMISSION_PCT"));
			System.out.println(rs.getInt("MANAGER_ID"));
			System.out.println(rs.getInt("DEPARTMENT_ID"));
		}
		
	}

}
