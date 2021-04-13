package com.springdata.associations.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.associations.onetoone.entity.License;

public interface LicenseRepository extends CrudRepository<License, Integer> {

}
