package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	public void view(String msg) {
		System.out.println(msg);
	}

	public void view(LocationDTO locationDTO) {
		System.out.println(locationDTO.getLOCATION_ID());
		System.out.println(locationDTO.getSTREET_ADDRESS());
		System.out.println(locationDTO.getPOSTAL_CODE());
		System.out.println(locationDTO.getCITY());
		System.out.println(locationDTO.getSTATE_PROVINCE());
		System.out.println(locationDTO.getCOUNTRY_ID());
	}
	public void view(ArrayList<LocationDTO> ar) {
		for(LocationDTO locationDTO:ar) {
			this.view(locationDTO);
		}
	}
}
