package com.springdata.clinicalsAPI.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.clinicalsAPI.entity.ClinicalData;
import com.springdata.clinicalsAPI.entity.Patient;
import com.springdata.clinicalsAPI.repository.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {
	
	
	private PatientRepository patientRepository;
	
	Map<String,String> filters = new HashMap();
	
	@Autowired
	public PatientController(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}


	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> getPatients()
	{
		return (List<Patient>) patientRepository.findAll();
	}
	
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") int id)
	{
		return patientRepository.findById(id).get();
	}
	
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient)
	{
		return patientRepository.save(patient);
	}
	
	@RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepository.findById(id).get();
		List<ClinicalData> listOfClinicalData = patient.getClinicalData();
		List<ClinicalData> duplicateListOfClinicalData = new ArrayList<>(listOfClinicalData);
		for (ClinicalData clinicalData : duplicateListOfClinicalData) {
			if(filters.containsKey(clinicalData.getComponentName())) {
				listOfClinicalData.remove(clinicalData);
				continue;
			}else
			{
				filters.put(clinicalData.getComponentName(), null);
			}
			
			if (clinicalData.getComponentName().equalsIgnoreCase("hw")) {
				String[] heightAndWeight = clinicalData.getComponentValue().split("/");
				if (heightAndWeight != null && heightAndWeight.length > 1) {
					float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
					float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
					ClinicalData bmiData = new ClinicalData();
					bmiData.setComponentName("bmi");
					bmiData.setComponentValue(Float.toString(bmi));
					listOfClinicalData.add(bmiData);
				}
			}
		}
		filters.clear();
		return patient;
	}

}
