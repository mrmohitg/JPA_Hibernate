package com.springdata.multipleDataSources.coupon.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.multipleDataSources.coupon.entity.Coupon;

public interface CouponRepository extends CrudRepository<Coupon, Long> {

}
