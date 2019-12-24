package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.PatientDetailsBO;

public class PatientDAOImpl implements PatientDAO {
	private static final String GET_ALL_PATIENTS_QUERY="SELECT PATIENTID,PATIENTNAME,AGE,ADRESS,PROBLEM,WARDNO,DOCTOR,CONTACT FROM PATIENT_INFO";
	
	private JdbcTemplate jt;
	
	public PatientDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
public PatientDAOImpl() {
	System.out.println("PatientDAOImpl::0-param Constructor");
}

	@Override
	public List<PatientDetailsBO> getAllPatients() {
		List<PatientDetailsBO> listBO=null;
		//use jdbctemplate
		listBO=(List<PatientDetailsBO>) jt.query(GET_ALL_PATIENTS_QUERY, new RowMapperResultSetExtractor
				                           (new BeanPropertyRowMapper(PatientDetailsBO.class)));
	
		return listBO;
	}

}
