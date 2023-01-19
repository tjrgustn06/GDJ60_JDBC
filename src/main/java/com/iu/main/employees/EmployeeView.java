package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	public void view(EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO.getEMPLOYEE_ID());
		System.out.println(employeeDTO.getFIRST_NAME());
		System.out.println(employeeDTO.getJOB_ID());
		System.out.println(employeeDTO.getDEPARTMENT_ID());
		
	}
	
	
	public void view(ArrayList<EmployeeDTO> ar) {
		for(EmployeeDTO employeeDTO:ar) {
			this.view(employeeDTO);
		}
	}

}
