package com.project.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.dashboard.model.Product;
import com.project.dashboard.service.ProductService;

@Controller
public class Main {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products=productService.getProducts();
		model.addAttribute("products", products);
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}

	
}
