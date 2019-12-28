package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.PatientDetailsCommand;
import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

public class EditPatientController extends SimpleFormController {
	private HospitalMgmtService service;

	public EditPatientController(HospitalMgmtService service) {
		this.service = service;
	}

	public EditPatientController() {
		System.out.println("EditPatientController::0-param constructor");
	}

	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
		int id = 0;
		// read patientId
		id = Integer.parseInt(req.getParameter("id"));
		// use service
		PatientDetailsDTO dto = null;
		dto = service.fetchPatientById(id);
		// create command obj and place dto obj to it
		PatientDetailsCommand cmd = new PatientDetailsCommand();
		BeanUtils.copyProperties(dto, cmd);
		return cmd;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command, BindException errors)
			throws Exception {
		String resultMsg = null;
		// type casting
		PatientDetailsCommand cmd = null;
		cmd = (PatientDetailsCommand) command;
		PatientDetailsDTO dto = null;
		
		dto= new PatientDetailsDTO(); 
		// convert cmd obj to dto obj
		BeanUtils.copyProperties(cmd, dto);
		// use Service
		resultMsg = service.modifyPatient(dto);

	List<PatientDetailsDTO> listDTO = service.fetchAllPatients();
	ModelAndView mav = null;
		mav = new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resultMsg",resultMsg);
		mav.setViewName(getSuccessView());
		return mav;

	}

}
