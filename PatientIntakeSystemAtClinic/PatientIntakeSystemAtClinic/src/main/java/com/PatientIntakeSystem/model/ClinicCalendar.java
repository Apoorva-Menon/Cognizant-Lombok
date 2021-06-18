package com.PatientIntakeSystem.model;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class ClinicCalendar {
	
	List<PatientAppointment> calendar = new ArrayList<>();
	
	public boolean addAppointment(PatientAppointment appointment) {
		
		for(PatientAppointment app : calendar)
		{
			LocalDateTime date = app.getDateOfAppointment();
			String doctor = app.getDoctorToMeet();
			if(appointment.getDateOfAppointment().isEqual(date) && appointment.getDoctorToMeet().equalsIgnoreCase(doctor))
				return false;
			else
			{
				calendar.add(appointment);
				return true;
			}
		}
	}
	
	public List<PatientAppointment> viewAllAppointments(){
		return calendar;
	}
}
