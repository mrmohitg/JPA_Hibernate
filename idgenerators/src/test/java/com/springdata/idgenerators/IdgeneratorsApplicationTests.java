package com.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.idgenerators.entity.Employee;
import com.springdata.idgenerators.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdgeneratorsApplicationTests {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateEmployee()
	{
		Employee employee = new Employee();
		employee.setName("Mohit");
		employeeRepository.save(employee);
	}

}
