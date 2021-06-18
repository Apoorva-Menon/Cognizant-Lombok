package com.PatientIntakeSystem.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PatientAppointment {
	
	private int patientId;
	private String patientName;
	private LocalDateTime dateOfAppointment;
	private String doctorToMeet;
}
