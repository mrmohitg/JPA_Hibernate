package com.springdata.patientScheduling.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.patientScheduling.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
