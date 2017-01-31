package com.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.domain.IndividualItem;


public interface IndividualItemDao extends MongoRepository<IndividualItem, String> {
	
}
