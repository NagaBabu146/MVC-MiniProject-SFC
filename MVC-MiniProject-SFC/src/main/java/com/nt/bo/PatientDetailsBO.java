package com.nt.bo;

import lombok.Data;

@Data
public class PatientDetailsBO {
	
	private int patientId;
	private String patientName;
	private int age;
	private String addres;
	private String problem;
	private int wardNo;
	private String contact;
	private String doctor;

}
