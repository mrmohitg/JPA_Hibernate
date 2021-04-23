package com.springdata.clinicalsAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.clinicalsAPI.dto.ClinicalDataRequest;
import com.springdata.clinicalsAPI.entity.ClinicalData;
import com.springdata.clinicalsAPI.entity.Patient;
import com.springdata.clinicalsAPI.repository.ClinicalDataRepository;
import com.springdata.clinicalsAPI.repository.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	private ClinicalDataRepository clinicalDataRepository;
	
	private PatientRepository patientRepository;
	
	@Autowired
	public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		super();
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}
	
	@RequestMapping(value= "/clinicals", method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest) {
		Patient patient = patientRepository.findById(clinicalDataRequest.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(clinicalDataRequest.getComponentName());
		clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
	}

}
