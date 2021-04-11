package com.springdata.jpqlandnativesql;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.jpqlandnativesql.entity.Student;
import com.springdata.jpqlandnativesql.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpqlandnativesqlApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testStudentCreate() {
		
		Student student = new Student();
		student.setFirstName("Nikhil");
		student.setLastName("Gupta");
		student.setScore(75);
		studentRepository.save(student);
		
		Student student1 = new Student();
		student1.setFirstName("Swati");
		student1.setLastName("Gupta");
		student1.setScore(66);
		studentRepository.save(student1);
		
		Student student11 = new Student();
		student11.setFirstName("Stuti");
		student11.setLastName("Gupta");
		student11.setScore(33);
		studentRepository.save(student11);
	}
	
	@Test
	public void testFindAllStudent()
	{
		System.out.println(studentRepository.findAllStudents());
	}
	
	@Test
	public void testFindAllStudentsPartialData()
	{
		List<Object[]> findAllStudentsPartialData = studentRepository.findAllStudentsPartialData();
		for (Object[] objects : findAllStudentsPartialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}
	
	@Test
	public void testFindAllStudentsByFirstName()
	{
		System.out.println(studentRepository.findAllStudentsByFirstName("Mohit"));
	}
	
	@Test
	public void testFindAllStudentsByScoresInBetween()
	{
		System.out.println(studentRepository.findAllStudentsByScoresInBetween(70,80));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentByFirstName()
	{
		studentRepository.deleteStudentByFirstName("Vipul");
	}
	
	@Test
	public void testFindAllStudentsPageWise()
	{
		System.out.println(studentRepository.findAllStudentsPageWise(PageRequest.of(0, 2)));
	}
	
	@Test
	public void testSortAllStudentsPageWise()
	{
		System.out.println(studentRepository.findAllStudentsPageWise(PageRequest.of(0, 10, Direction.DESC, "score")));
	}
	
	
}
