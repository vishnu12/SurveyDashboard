package com.project.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dashboard.model.Product;
import com.project.dashboard.service.ProductService;

@Controller
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/add")
	public String getPage() {
		return "add-product";
	}
	
	@ModelAttribute("product")
	public Product getProduct() {
		return new Product();
	}
	
	@PostMapping("/add")
	public String addProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/";
	}
	
	
	
	
}
