package com.springdata.idgenerators.repo;

import org.springframework.data.repository.CrudRepository;

import com.springdata.idgenerators.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
