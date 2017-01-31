package com.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.dao.IndividualItemDao;
import com.mongo.dao.ProductDao;
import com.mongo.domain.IndividualItem;
import com.mongo.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	@Autowired
	IndividualItemDao individualItemDao;

	@Override
	public List<Product> findAllProduct() {
		return productDao.findAll();
	}

	@Override
	public void saveProduct(Product p) {
		List<IndividualItem> itemList = new ArrayList<>();
//		if (itemList == null)
//			itemList = new ArrayList<>();
		for (int i = 1; i <= p.getQuantity(); i++) {
			IndividualItem item = new IndividualItem();
			individualItemDao.save(item);
			itemList.add(item);
		}
		p.setListItems(itemList);
		productDao.save(p);

	}

	@Override
	public void deleteProduct(String productId) {
		Product product = productDao.findByProductId(productId);
		System.out.println("arun=" + product);
		if (product != null)
			productDao.delete(product);
	}

	@Override
	public Product getProductByProductId(String productId) {
		Product product = productDao.findByProductId(productId);
		if (product != null)
			return product;
		else
			return null;
	}

}
