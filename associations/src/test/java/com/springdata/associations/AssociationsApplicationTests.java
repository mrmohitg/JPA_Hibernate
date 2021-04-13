package com.springdata.associations;

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

import com.springdata.associations.onetomany.entity.Actor;
import com.springdata.associations.onetomany.entity.PhoneNumber;
import com.springdata.associations.onetomany.repository.ActorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	private ActorRepository actorRepository;

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

}
