package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {
	private Scanner sc;
	
	
	public LocationInput() {	
	
	  sc= new Scanner(System.in);	
	}
	
	//수정
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("수정할 지역 번호 입력");
		locationDTO.setLOCATION_ID(sc.nextInt());
		System.out.println("수정할 주소 입력");
		locationDTO.setSTREET_ADDRESS(sc.next());
		System.out.println("우편번호 입력");
		locationDTO.setPOSTAL_CODE(sc.next());
		
		return locationDTO;
	}

	//추가
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("지역 번호 입력");
		locationDTO.setLOCATION_ID(sc.nextInt());
		System.out.println("주소 입력");
		locationDTO.setSTREET_ADDRESS(sc.next());
		System.out.println("우편번호 입력");
		locationDTO.setPOSTAL_CODE(sc.next());
		System.out.println("도시 입력");
		locationDTO.setCITY(sc.next());
		System.out.println("동내 입력");
		locationDTO.setSTATE_PROVINCE(sc.next());
		System.out.println("나라 입력");
		locationDTO.setCOUNTRY_ID(sc.next());
		
		return locationDTO;
	}
	
	//삭제
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("삭제할 도시 번호를 입력");
		locationDTO.setLOCATION_ID(sc.nextInt());
		
		return locationDTO;

	}
}
