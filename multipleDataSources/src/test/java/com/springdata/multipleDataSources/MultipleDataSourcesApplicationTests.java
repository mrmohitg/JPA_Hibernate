package com.springdata.multipleDataSources;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdata.multipleDataSources.coupon.entity.Coupon;
import com.springdata.multipleDataSources.coupon.repository.CouponRepository;
import com.springdata.multipleDataSources.product.entity.Product;
import com.springdata.multipleDataSources.product.repository.ProductRepository;

@SpringBootTest
class MultipleDataSourcesApplicationTests {
	
	@Autowired
	CouponRepository couponRepository;

	@Autowired
	ProductRepository productRepository;

	@Test
	void testSaveCoupon() {
		Coupon coupon = new Coupon();
		coupon.setCode("SUPERSALE");
		coupon.setDiscount(new BigDecimal(20));
		coupon.setExpDate("22/22/2022");
		System.out.println(couponRepository.save(coupon));
	}

	@Test
	void testSaveProduct() {
		Product product = new Product();
		product.setName("MAC BOOK PRO");
		product.setDescription("Its Cool");
		product.setPrice(new BigDecimal(2000));
		product.setCouponCode("SUPERSALE");
		System.out.println(productRepository.save(product));
	}}
