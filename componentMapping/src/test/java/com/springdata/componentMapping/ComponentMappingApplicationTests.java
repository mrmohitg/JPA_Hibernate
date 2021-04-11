package com.springdata.componentMapping;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.componentMapping.entity.Address;
import com.springdata.componentMapping.entity.Teacher;
import com.springdata.componentMapping.repository.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComponentMappingApplicationTests {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("Chris");
		Address address = new Address();
		address.setStreetaddress("SewaMarg");
		address.setCity("New Delhi");
		address.setState("Delhi");
		address.setZipcode("110098");
		address.setCountry("Bharat");
		teacher.setAddress(address);
		teacherRepository.save(teacher);
	}

}
