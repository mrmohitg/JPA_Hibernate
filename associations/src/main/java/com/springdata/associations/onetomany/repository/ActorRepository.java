package com.springdata.associations.onetomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.associations.onetomany.entity.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}
