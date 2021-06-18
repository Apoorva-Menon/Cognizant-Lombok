package com.lombok.FlightManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.log4j.Log4j2;

import com.lombok.FlightManagement.model.Flight;
import com.lombok.FlightManagement.model.Passenger;

import java.util.ArrayList;

@Controller
@Log4j2
public class FlightManagementController {
	
	Flight eFlight = new Flight("EF1", "Economy", new ArrayList<Passenger>());
	Flight bFlight = new Flight("BF1", "Business", new ArrayList<Passenger>());
	
	@RequestMapping(path="flights/{flightType}", method=RequestMethod.POST)
	public String addNewPassenger(@PathVariable String flightType, @RequestBody Passenger passenger) {
		log.debug("Checking if passenger can be added!");
		
		
		if (flightType.toLowerCase().equals("economy")) {
			if (eFlight.addPassenger(passenger)==true) {
				log.debug("The passenger has been added successfully to the Economy class!");
				return "The passenger has been added successfully to the Economy class!";
			} 
			else {
				log.debug("The passenger was not added to Economy class");
				return "The passenger was not added to Economy class";
			}
		} 
		else{
			if ( bFlight.addPassenger(passenger)==true) {
				log.debug("The passenger has been added successfully to the Business class!");
				return "The passenger has been added successfully to the Business class!";
			} 
			else {
				log.debug("The passenger was not added to Business class!");
				return "The passenger was not added to Business class!";
			}
		}
		return "";
	}
	
	@RequestMapping(path="flights/{flightType}", method=RequestMethod.DELETE)
	public String removeExistingPassenger(@PathVariable String flightType, @RequestBody Passenger passenger) {
		log.debug("Checking if passenger can be removed");
		
		if (flightType.toLowerCase().equals("economy")) {
			if (eFlight.removePassenger(passenger)) {
				log.debug("The passenger has been removed successfully from the Economy class!");
				return "The passenger has been removed successfully from the Economy class!";
			} 
			else {
				log.debug("The passenger could not be removed from economy class");
				return "The passenger could not be removed from economy class";
			}
		} 
		else{
			if (bFlight.removePassenger(passenger)) {
				log.debug("The passenger has been removed successfully from the Business class!");
				return "The passenger has been removed successfully from the Business class!";
			} 
			else {
				log.debug("The passenger could not be removed from Business class!");
				return "The passenger could not be removed from Business class!";
			}
		}
		return "";
	}
}