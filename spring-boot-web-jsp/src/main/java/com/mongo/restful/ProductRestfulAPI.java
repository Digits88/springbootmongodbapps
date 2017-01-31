package com.mongo.restful;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongo.domain.Product;
import com.mongo.service.ProductService;

@Controller
public class ProductRestfulAPI {
@Autowired
ProductService productService;
@RequestMapping("/product-rest-info")
@ResponseBody
public List<Product> productRestInfo(){
	return productService.findAllProduct();
}
}
