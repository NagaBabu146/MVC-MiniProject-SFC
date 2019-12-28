package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.nt.bo.PatientDetailsBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDetailsDTO;

public class HospitalMgmtServiceImpl implements HospitalMgmtService {
	
	private PatientDAO dao;
	
	public HospitalMgmtServiceImpl(PatientDAO dao) {
		this.dao = dao;
	}
	
	public HospitalMgmtServiceImpl() {
		System.out.println("HospitalMgmtServiceImpl::0-param constructor");
	}
	
	@Override
	public List<PatientDetailsDTO> fetchAllPatients() {
		
		List<PatientDetailsBO> listBO = null;
		List<PatientDetailsDTO> listDTO = new ArrayList();
		
		// use dao
		listBO = dao.getAllPatients();
		
		// convert listBO to listDTO
		listBO.forEach(bo -> {
			PatientDetailsDTO dto = new PatientDetailsDTO();
			BeanUtils.copyProperties(bo, dto);
			
			dto.setSrNo(listDTO.size()+1);
		
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public PatientDetailsDTO fetchPatientById(int id) {
		System.out.println("fetchById:in Service");
		
		PatientDetailsBO bo = null;
		PatientDetailsDTO dto = null;
		
		dto = new PatientDetailsDTO();
		// use dao
		bo = dao.getPatientById(id);
		// convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	public String modifyPatient(PatientDetailsDTO dto) {
	
		PatientDetailsBO bo=null;
		bo=new PatientDetailsBO();
		
		//convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		
	int count=	dao.updatePatient(bo);
	
	if(count==0)
		return "patient details are  not updated";
	else
		return "patient details are updated successfully";
	}
}
