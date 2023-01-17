package com.iu.main;

import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		
		System.out.println("Start");
		DBConnection con = new DBConnection();
		
		//참조변수몇.멤버들
		try {
			con.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("finish");
	}

}
