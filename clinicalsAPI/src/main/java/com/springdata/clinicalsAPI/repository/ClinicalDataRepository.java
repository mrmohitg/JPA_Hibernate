package com.springdata.clinicalsAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.clinicalsAPI.entity.ClinicalData;

public interface ClinicalDataRepository extends CrudRepository<ClinicalData, Integer> {

}
