package com.nt.command;

import lombok.Data;

@Data
public class PatientDetailsCommand {
    
	private int patientId;
	private String patientName;
	private int age;
	private String addres;
	private String problem;
	private int wardNo;
	private String contact;
	private String doctor;
}
