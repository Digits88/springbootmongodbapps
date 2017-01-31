package com.mongo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongo.dao.ProductDao;
import com.mongo.domain.Product;
import com.mongo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String homePage() {
		return "redirect:view-all-products";

	}

	@RequestMapping("/save-product")
	public String saveProduct(@Valid Product p, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-product";
		}
		productService.saveProduct(p);
		return "redirect:view-all-products";
	}

	@RequestMapping("/view-all-products")
	public String viewAllProducts(Model model) {
		model.addAttribute("pList", productService.findAllProduct());
		return "view-all-products";

	}

	@RequestMapping("add-product")
	public String addProduct(Product p) {
		return "add-product";
	}

	// Delete product
	@RequestMapping("/delete-product/{productid}")
	public String DeleteProduct(@PathVariable("productid") String productid, Model model) {
		productService.deleteProduct(productid);
		model.addAttribute("pList", productService.findAllProduct());
		return "view-all-products";
	}
	// update product based on product id
		@RequestMapping(value = "/update-product/{productid}")
		public String editProduct(@PathVariable("productid") String productId, HttpSession session, Product product) {
			session.setAttribute("productObject", productService.getProductByProductId(productId));
			return "update-product";

		}
	
		// update existing product
		@RequestMapping("/update-product-info")
		public String updateProduct(@Valid Product product, HttpSession session, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				System.out.println("how are you");
				return "update-product";
			}
			Product p = (Product) session.getAttribute("productObject");
			p.setProductName(product.getProductName());
			p.setCategory(product.getCategory());
			p.setDescription(product.getDescription());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());
			productService.saveProduct(p);
			return "redirect:view-all-products";
		}
}
