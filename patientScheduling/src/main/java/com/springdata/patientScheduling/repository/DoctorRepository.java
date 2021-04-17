package com.springdata.patientScheduling.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.patientScheduling.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
