package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		
		System.out.println("Start");
		DepartmentController dc = new DepartmentController();
		LocationController lc = new LocationController();
		EmployeeController ec = new EmployeeController();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		LocationDAO locationDAO = new LocationDAO();
		try {
			
			//ec.start();
			//dc.start();
			//lc.start();
//			LocationDTO locationDTO = new LocationDTO();
//			locationDTO.setLOCATION_ID(3300);
//			locationDTO.setSTREET_ADDRESS("214mariano");
//			locationDTO.setPOSTAL_CODE("1234");
//			locationDTO.setCITY("mexico");
//			locationDTO.setSTATE_PROVINCE("null");
//			locationDTO.setCOUNTRY_ID("it");
//			int result = locationDAO.setData(locationDTO);
//			
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_name("TestIT");
//			departmentDTO.setManager_id(200);
//			departmentDTO.setLocation_id(170011);
//			int result = departmentDAO.setData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");				
//			}else {
//				System.out.println("실패");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println("finish");
	}

}
