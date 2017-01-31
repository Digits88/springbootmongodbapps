package com.mongo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class IndividualItem {
	@Id
	private ObjectId itemNumber;

	public IndividualItem() {
	}

	public ObjectId getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(ObjectId itemNumber) {
		this.itemNumber = itemNumber;
	}

	

}
