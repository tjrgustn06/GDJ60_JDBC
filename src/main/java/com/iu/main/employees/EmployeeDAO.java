package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	EmployeeDTO employeeDTO = null;
	//method 1 : query 1 메서드 하나당 쿼리문도 하나씩만 가능
	
	//월급 평균
	public void getAvg() throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY), SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();		
		
		rs.next();
		
		System.out.println(rs.getDouble(1));
		System.out.println(rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, connection);
		
	}
	
	
	
	//수정
	
	//삭제
	
	//추가
	
	public int setData(EmployeeDTO employeeDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE,"
				+ " JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID"
				+ " VALUES(EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEMPLOYEE_ID());
		st.setString(2, employeeDTO.getFIRST_NAME());
		st.setString(3, employeeDTO.getLAST_NAME());
		st.setString(4, employeeDTO.getEMAIL());
		st.setString(5, employeeDTO.getPHONE_NUMBER());
		st.setDate(6, employeeDTO.getHIRE_DATE());
		st.setString(7, employeeDTO.getJOB_ID());
		st.setDouble(8, employeeDTO.getSALARY());
		st.setDouble(9, employeeDTO.getCOMMISSION_PCT());
		st.setInt(10, employeeDTO.getDEPARTMENT_ID());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	//3. Last_name 라스트네임으로 사원찾기
	
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLIYEES WHERE LAST_NAME LIKE  '%||?||%'";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, search);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeeDTO.setLAST_NAME(rs.getString("LAST_NAME"));
			employeeDTO.setSALARY(rs.getDouble("SALARY"));
			employeeDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeeDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setHIRE_DATE(rs.getDate("HIRE_DATE"));
			employeeDTO.setEMAIL(rs.getString("EMAIL"));
			employeeDTO.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
			employeeDTO.setCOMMISSION_PCT(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setMANAGER_ID(rs.getInt("MANAGER_ID"));
			ar.add(employeeDTO);		
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	
	//2. 사원번호로 사원전체정보 찾기
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeeDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeeDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));		
		}else {
			System.out.println("Data가 없습니다");
		}
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
	}
	// 1.List
	public ArrayList<EmployeeDTO> getList() throws Exception {
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		Connection connection = DBConnection.getConnection();
		//Query문 생성
		String sql ="SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC ";
		//미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		//4.?(지금은 없어서 패스)
		
		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeeDTO.setLAST_NAME(rs.getString("LAST_NAME"));
			employeeDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeeDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);

		}
		//연결 해제
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}
