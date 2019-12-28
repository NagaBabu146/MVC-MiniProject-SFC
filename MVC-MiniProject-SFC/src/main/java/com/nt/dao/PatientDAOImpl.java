package com.nt.dao;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import com.nt.bo.PatientDetailsBO;
import com.nt.dto.PatientDetailsDTO;

public class PatientDAOImpl implements PatientDAO {
	private static final String GET_ALL_PATIENTS_QUERY = "SELECT PATIENTID,PATIENTNAME,AGE,ADRESS,PROBLEM,WARDNO,DOCTOR,CONTACT FROM PATIENTS_INFO";
	private static final String GET_PATIENTDETAILS_BY_ID = "SELECT PATIENTID,PATIENTNAME,AGE,ADRESS,PROBLEM,WARDNO,DOCTOR,CONTACT FROM PATIENTS_INFO WHERE PATIENTID=?";
	private static final String UPDATE_PATIENT_BY_ID = "UPDATE PATIENTS_INFO SET PATIENTNAME=?,AGE=?,ADRESS=?,PROBLEM=?,WARDNO=?,DOCTOR=?,CONTACT=? WHERE PATIENTID=?";
	private JdbcTemplate jt;

	public PatientDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public PatientDAOImpl() {
		System.out.println("PatientDAOImpl::0-param Constructor");
	}

	@Override
	public List<PatientDetailsBO> getAllPatients() {
		List<PatientDetailsBO> listBO = null;
		// use JdbcTemplate
		listBO = (List<PatientDetailsBO>) jt.query(GET_ALL_PATIENTS_QUERY , 
				             new RowMapperResultSetExtractor(new BeanPropertyRowMapper(PatientDetailsBO.class)));
		return listBO;
	}

	@Override
	public PatientDetailsBO getPatientById(int id) {
		PatientDetailsBO bo = null;
		// use jdbc Template
		bo = (PatientDetailsBO) jt.queryForObject(GET_PATIENTDETAILS_BY_ID,
				                   new BeanPropertyRowMapper(PatientDetailsBO.class), id);
		return bo;
	}

	@Override
	public int updatePatient(PatientDetailsBO bo) {
		int count = 0;
		count = jt.update(UPDATE_PATIENT_BY_ID, bo.getPatientName(), bo.getAge(), bo.getAddres(), bo.getProblem(),
				         bo.getWardNo(), bo.getDoctor(), bo.getContact(), bo.getPatientId());
		return count;
	}
}
