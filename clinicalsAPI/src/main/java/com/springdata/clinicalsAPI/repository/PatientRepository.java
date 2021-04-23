package com.springdata.clinicalsAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.clinicalsAPI.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
