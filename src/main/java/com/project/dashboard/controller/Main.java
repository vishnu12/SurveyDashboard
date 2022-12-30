package com.project.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.dashboard.model.Product;
import com.project.dashboard.model.User;
import com.project.dashboard.service.ProductService;
import com.project.dashboard.service.UserService;

@Controller
public class Main {
	
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email=((UserDetails)principal).getUsername();
		User user=userService.findUserByEmail(email);
		List<Product> products=productService.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}

	
}
