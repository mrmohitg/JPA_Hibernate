package com.springdata.componentMapping.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.componentMapping.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
