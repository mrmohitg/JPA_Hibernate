package com.springdata.patientScheduling.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.patientScheduling.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
