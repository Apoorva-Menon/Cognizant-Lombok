package com.PatientIntakeSystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PatientIntakeSystem.model.PatientAppointment;
import com.PatientIntakeSystem.model.ClinicCalendar;

@SpringBootApplication
public class PatientIntakeSystemAtClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientIntakeSystemAtClinicApplication.class, args);
		Scanner sc = new Scanner(System.in);
		log.info("Welcome to City Clinic!");
		log.info("Menu:");
		log.info("1.Add Apppointment");
		log.info("2.View All Appointments");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice==1)
		{
			PatientAppointment newAppointmentRequest = new PatientAppointment(101,"Sanya Malhotra","10-07-2021 18:30", Doctor.ENTSpecialist);
			ClinicCalendar cc = new ClinicCalendar();
			log.info("Checking Calendar");
			if(cc.addAppointment(newAppointmentRequest))
			{
				log.info("Appointment added successfully");
			}
			else
			{
				log.error("Sorry this slot is already occupied!");
			}
		}
		
		else if(choice==2)
		{
			ClinicCalendar cc = new ClinicCalendar();
			List<PatientAppointment> pa = cc.viewAllAppointments();
			if(pa.size() < 1)
			{
				log.error("No Appointments");
			}
			else
			{
				int i=0;
				log.info("Please wait patiently... Fetching Appointment List...");
				for(PatientAppointment app : pa)
				{
					log.info(++i + ". " + pa.toString());
				}
			}
		}
		
	}
	}

}
