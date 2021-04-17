package com.springdata.patientScheduling;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.patientScheduling.entity.Appointment;
import com.springdata.patientScheduling.entity.Doctor;
import com.springdata.patientScheduling.entity.Insurance;
import com.springdata.patientScheduling.entity.Patient;
import com.springdata.patientScheduling.repository.AppointmentRepository;
import com.springdata.patientScheduling.repository.DoctorRepository;
import com.springdata.patientScheduling.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientSchedulingApplicationTests {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateDoctor() {
		
		Doctor doctor = new Doctor();
		doctor.setFirstName("John");
		doctor.setLastName("Stokes");
		doctor.setSpeciality("Nuero");
		doctorRepository.save(doctor);
	}
	
	@Test
	void testCreatePatient() {
		
		Patient patient = new Patient();
		patient.setFirstName("John");
		patient.setLastName("Stokes");
		patient.setPhone("123456");
		Insurance insurance = new Insurance();
		insurance.setProviderName("Star Health");
		insurance.setCopay(25d);
		patient.setInsurance(insurance);
		Optional<Doctor> doctor = doctorRepository.findById(1L);
		List<Doctor> doctors = doctor.stream().collect(Collectors.toList());
		patient.setDoctors(doctors);
		patientRepository.save(patient);
	}
	
	@Test
	void testCreateApointment() {
		
		Optional<Doctor> doctor = doctorRepository.findById(1L);
		List<Doctor> doctors = doctor.stream().collect(Collectors.toList());
		
		Optional<Patient> patient = patientRepository.findById(1L);
		List<Patient> patients = patient.stream().collect(Collectors.toList());
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentTime(new Timestamp(new Date().getTime()));
		appointment.setReason("Headache");
		appointment.setDoctor(doctors.get(0));
		appointment.setPatient(patients.get(0));
		appointment.setStarted(true);
		appointment.setEnded(false);
		
		appointmentRepository.save(appointment);
	}

}
