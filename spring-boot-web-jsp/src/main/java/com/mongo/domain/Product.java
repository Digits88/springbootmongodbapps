package com.mongo.domain;

import java.util.List;

import javax.validation.constraints.DecimalMin;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Product {
	@Id
	private ObjectId productId;
	@NotBlank
	@Indexed
	private String productName;
	@NotBlank
	private String category;
	@NotBlank
	private String description;
	@DecimalMin("0.0")
	private double price;
	@DecimalMin("0.0")
	private double quantity;
	@DBRef 
	List<IndividualItem> listItems;

	public Product() {

	}

	public Product(String productName, String category, String description, double quantity, double price) {
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	
	public ObjectId getProductId() {
		return productId;
	}

	public void setProductId(ObjectId productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<IndividualItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<IndividualItem> listItems) {
		this.listItems = listItems;
	}

}
