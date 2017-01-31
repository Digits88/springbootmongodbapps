package com.mongo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.domain.Product;

public interface ProductDao extends MongoRepository<Product, String> {
	Product findByProductId(String productId);

	Page<Product> findAll(Pageable pageable);
}
