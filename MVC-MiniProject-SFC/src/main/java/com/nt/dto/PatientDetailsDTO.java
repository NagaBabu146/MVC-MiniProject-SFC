package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsDTO implements Serializable {
    private int srNo;
	private int patientId;
	private String patientName;
	private int age;
	private String addres;
	private String problem;
	private int wardNo;
	private String contact;
	private String doctor;
}
