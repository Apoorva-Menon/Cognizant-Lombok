package com.lombok.FlightManagement.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Flight {
	private String id;
	private String flightType;
	private List<Passenger> passengers;

	public boolean addPassenger(Passenger passenger) {
		if(passenger.isVip()==false && flightType.equalsIgnoreCase("business")){
			return false;
		}
		passengers.add(passenger);
		return true;
	}

	public boolean removePassenger(Passenger passenger) {
		if (passenger.isVip()) {
			return false;
		}
		return passengers.remove(passenger);
	}
}