package com.lombok.FlightManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Passenger {
	private String name;
	private boolean vip;
	
	public boolean isVip() {
		if(vip==true)
			return true;
		return false;
	}
}