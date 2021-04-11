package com.springdata.customer.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByNameAndEmail(String name, String email);
	
	List<Customer> findByEmailLike(String email);
	
	List<Customer> findByIdIn(List<Integer> id);
	
	@Modifying
	@Query("update Customer set email = :email where id = :id")
	Integer updateCustomerEmail(@Param("id") int id,@Param("email") String email); 
	
	@Query("from Customer")
	List<Customer> findByNameAndEmailPaging(Pageable pageable);

}
