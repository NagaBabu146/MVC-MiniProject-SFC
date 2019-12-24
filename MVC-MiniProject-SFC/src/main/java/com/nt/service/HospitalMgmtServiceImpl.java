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
		
		List<PatientDetailsBO> listBO =null;
		List<PatientDetailsDTO> listDTO =new ArrayList();
		//use dao
		listBO=dao.getAllPatients();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			PatientDetailsDTO dto=new PatientDetailsDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
