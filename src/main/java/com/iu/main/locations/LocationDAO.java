package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class LocationDAO {
	LocationDTO locationDTO = null;
	
	public int updateData(LocationDTO locationDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql ="UPDATE LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=? "
				+ "WHERE LOCATION_ID = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, locationDTO.getSTREET_ADDRESS());
		st.setString(2, locationDTO.getPOSTAL_CODE());
		st.setInt(3, locationDTO.getLOCATION_ID());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}

	
	public int deleteData(LocationDTO locationDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, locationDTO.getLOCATION_ID());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	public int setData(LocationDTO locationDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE,COUNTRY_ID)"
				+ " VALUES (LOCATIONS_SEQ.NEXTVAL,?,?,?,?,?,";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, locationDTO.getSTREET_ADDRESS());
		st.setString(2, locationDTO.getPOSTAL_CODE());
		st.setString(3, locationDTO.getCITY());
		st.setString(4, locationDTO.getSTATE_PROVINCE());
		st.setString(5, locationDTO.getCOUNTRY_ID());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
			
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
		
	}
	
	
	public  LocationDTO getDetail(int location_id) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, location_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
		}else {
			System.out.println("Data가 없다");
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return locationDTO;
		
	}
	
	
	
	public ArrayList<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		//DBConnection dbConnection = new DBConnection();
		Connection connection = DBConnection.getConnection();
		
				//3.Query문 생성
		String sql = "SELECT * FROM LOCATIONS";
				
				//4.Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
				
				//5.? 세팅(있으면 하고 없으면 안함)
				
				//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
		locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
		locationDTO.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
		locationDTO.setCITY(rs.getString("CITY"));
		locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
		locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
		ar.add(locationDTO);
		}		
				//7.연결 해제
		DBConnection.disConnect(rs, st, connection);
		return ar;
		
	}

}
