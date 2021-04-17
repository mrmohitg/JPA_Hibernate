package com.springdata.fileData.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.fileData.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
