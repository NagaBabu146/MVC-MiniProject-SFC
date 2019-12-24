package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

public class ListPatientController extends AbstractController {

	private HospitalMgmtService service;
	
	public ListPatientController(HospitalMgmtService service) {
		this.service = service;
	}
	
public ListPatientController() {
	System.out.println("ListPatientController::0-param constructor");
}

	@Override
	public  ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//use service
		List<PatientDetailsDTO> listDTO = service.fetchAllPatients();
		
		//create mav obj
		return new ModelAndView("list_patients", "listDTO", listDTO);
	}

}
