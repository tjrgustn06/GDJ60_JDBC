package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	
	public LocationController() {
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		this.locationInput = new LocationInput();
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<LocationDTO> ar= null;
		while(check) {
			System.out.println("1. 주소 전체정보");
			System.out.println("2. 주소 상세정보");
			System.out.println("3. 주소    검색");
			System.out.println("4. 주 소 추 가 ");
			System.out.println("5. 주 소 삭 제 ");
			System.out.println("6. 주 소 수 정");
			System.out.println("7.종       료 ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				 ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("LOCATION ID를 입력하세요");
				select =sc.nextInt();
			LocationDTO locationDTO = locationDAO.getDetail(select);
				
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("Data가 없습니다");
				}
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = sc.next();
				 ar = locationDAO.getFind(add);
				 locationView.view(ar);				 
				break;				
			case 4:
				locationDTO = locationInput.setData();
				select = locationDAO.setData(locationDTO);
				
				if(select>0) {
					locationView.view("추가 성공");
				}else {
					locationView.view("추가 실패");
				}
				break;
			case 5:
				locationDTO = locationInput.deleteData();
				select = locationDAO.deleteData(locationDTO);
				
				if(select>0) {
					locationView.view("삭제 성공");
				}else {
					locationView.view("삭제 실패");
				}
				
				break;
			case 6: locationDTO = locationInput.updateData();
					select = locationDAO.updateData(locationDTO);
					
					if(select>0) {
						locationView.view("수정 성공");
					}else {
						locationView.view("수정 실패");
					}
					break;
				default:
					check = false;
			}
		}
	}

}
