package com.springdata.associations.manytomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.associations.manytomany.entity.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
