package com.springdata.jpqlandnativesql.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.jpqlandnativesql.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select st.firstName, st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName =:firstName")
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score > :minScore and score < :maxScore")
	List<Student> findAllStudentsByScoresInBetween(@Param("minScore") int minScore, @Param("maxScore") int maxScore);
	
	@Modifying
	@Query("delete from Student where firstName = :fName")
	void deleteStudentByFirstName(@Param("fName") String firstName);
	
	@Query("from Student")
	List<Student> findAllStudentsPageWise(Pageable pageable);
	
	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentsNQ();
	
	@Query(value = "select * from student where fname = :firstName", nativeQuery = true)
	List<Student> findByFirstNameNQ(@Param ("firstName") String firstname);


}
