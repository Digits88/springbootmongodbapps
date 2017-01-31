package com.mongo.service;

import java.util.List;
import com.mongo.domain.Product;

public interface ProductService {
	List<Product> findAllProduct();
	public void saveProduct(Product p);
	public void deleteProduct(String productId);
	Product getProductByProductId(String productId);
}
