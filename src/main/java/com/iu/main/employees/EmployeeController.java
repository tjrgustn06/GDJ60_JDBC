package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	
	public EmployeeController() {
		this.sc = new Scanner(System.in);
		this.employeeDAO = new EmployeeDAO();
		this.employeeView = new EmployeeView();
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1.사원정보 리스트");
			System.out.println("2. 개별 사원정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ArrayList<EmployeeDTO> ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("검색할 사원번호를 입력하세요");
				select = sc.nextInt();
				EmployeeDTO employeeDTO = employeeDAO.getDetail(select);
				
				if(employeeDTO !=null) {
					employeeView.view(employeeDTO);
				}else {
					employeeView.view("Data없음");
				}
				break;
			case 3:
				break;
				default:
					check = false;
			}
		}
	}

}
