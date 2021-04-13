package com.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.associations.manytomany.entity.Programmer;
import com.springdata.associations.manytomany.entity.Project;
import com.springdata.associations.manytomany.repository.ProgrammerRepository;
import com.springdata.associations.onetomany.entity.Actor;
import com.springdata.associations.onetomany.entity.PhoneNumber;
import com.springdata.associations.onetomany.repository.ActorRepository;
import com.springdata.associations.onetoone.entity.License;
import com.springdata.associations.onetoone.entity.Person;
import com.springdata.associations.onetoone.repository.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ProgrammerRepository programmerRepository;
	
	@Autowired
	private LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateActor() {
		// First Way To create test Data
		/*
		 * Actor actor = new Actor(); 
		 * actor.setName("Shahrukh Khan");
		 * HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>(); 
		 * PhoneNumber phoneNumber = new PhoneNumber(); 
		 * phoneNumber.setNumber("9910374148");
		 * phoneNumber.setType("Mobile"); 
		 * phoneNumber.setActor(actor);
		 * numbers.add(phoneNumber); 
		 * PhoneNumber phoneNumber1 = new PhoneNumber();
		 * phoneNumber1.setNumber("9958878382"); 
		 * phoneNumber1.setType("Mobile");
		 * phoneNumber1.setActor(actor); 
		 * numbers.add(phoneNumber1);
		 * actor.setNumbers(numbers); 
		 * actorRepository.save(actor);
		 */
		
		//Better way of handling the foreign key
		Actor actor = new Actor();
		actor.setName("Shahrukh Khan");
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("9910374148");
		phoneNumber.setType("Mobile");
		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setNumber("9958878382");
		phoneNumber1.setType("Mobile");
		actor.addPhoneNumber(phoneNumber);
		actor.addPhoneNumber(phoneNumber1);
		actorRepository.save(actor);
	}
	
	@Test
	@Transactional
	void testLoadActor() {
		Optional<Actor> actor = actorRepository.findById(1L);
		Actor actoras = actor.get();
		System.out.println(actoras.getName());
		
		Set<PhoneNumber> numbers = actoras.getNumbers();
		numbers.forEach(N -> System.out.println(N.getNumber()));

	}
	
	@Test
	@Transactional
	@Rollback(false)
	void testUpdateActor() {
		Optional<Actor> actor = actorRepository.findById(1L);
		Actor actoras = actor.get();
		actoras.setName("Aamir Khan");
		
		Set<PhoneNumber> numbers = actoras.getNumbers();
		numbers.forEach(N -> N.setType("Mobile"));

		actorRepository.save(actoras);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void testDeleteActor() {
		actorRepository.deleteById(1L);
	}
	
	@Test
	void testCreateProgrammer() {
		  Programmer programmer = new Programmer();
		  programmer.setName("Mohit");
		  programmer.setSalary(30000);
		 
		  HashSet<Project> projects = new HashSet<Project>(); 
		  Project project = new Project(); 
		  project.setName("DRC");
		  projects.add(project); 
		 
		  Project project1 = new Project(); 
		  project1.setName("LMPS");
		  projects.add(project1);
		  
		  Project project2 = new Project(); 
		  project2.setName("CP2.0");
		  projects.add(project2);
		  
		  programmer.setProjects(projects);
		  programmerRepository.save(programmer);
		 

	}
	
	@Test
	@Transactional
	void testLoadProgrammer() {
		Optional<Programmer> programmer = programmerRepository.findById(1);
		Programmer programmeras = programmer.get();
		System.out.println(programmeras);
		System.out.println(programmeras.getProjects());
	}

	
	@Test
	void testCreateLicense() {
		Person person = new Person();
		person.setFirst_name("Mohit");
		person.setLast_name("Gupta");
		person.setAge(30);

		License license = new License();
		license.setType("CAR");
		license.setValid_from(new Date());
		license.setValid_to(new Date());
		license.setPerson(person);
		licenseRepository.save(license);

	}
}
