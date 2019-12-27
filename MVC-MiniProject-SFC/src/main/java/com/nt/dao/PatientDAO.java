package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientDetailsBO;
import com.nt.dto.PatientDetailsDTO;

public interface PatientDAO {

	public List<PatientDetailsBO> getAllPatients();
	public PatientDetailsBO getPatientById(int id);
	public int updatePatient(PatientDetailsBO bo);
	
}
