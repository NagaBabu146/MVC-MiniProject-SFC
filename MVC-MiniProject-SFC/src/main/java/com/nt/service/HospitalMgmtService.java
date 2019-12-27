package com.nt.service;

import java.util.List;

import com.nt.dto.PatientDetailsDTO;

public interface HospitalMgmtService {

	public List<PatientDetailsDTO> fetchAllPatients();
	public PatientDetailsDTO fetchPatientById(int id);
	public String modifyPatient(PatientDetailsDTO dto);
}
