package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientDetailsBO;

public interface PatientDAO {

	public List<PatientDetailsBO> getAllPatients();
}
