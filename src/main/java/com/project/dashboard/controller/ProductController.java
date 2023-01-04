package com.project.dashboard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dashboard.model.Feedback;
import com.project.dashboard.model.Product;
import com.project.dashboard.service.FeedbackService;
import com.project.dashboard.service.ProductService;


@Controller
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	FeedbackService feedbackService;

	@GetMapping("/add")
	@PreAuthorize("hasAnyAuthority('Admin','Prevl_User')")
	public String getPage() {
		return "add-product";
	}
	
	@ModelAttribute("product")
	public Product getProduct() {
		return new Product();
	}
	
	@ModelAttribute("feedback")
	public Feedback getFeedback() {
		return new Feedback();
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('Admin','Prevl_User')")
	public String addProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	@PreAuthorize("hasAnyAuthority('Admin','Prevl_User')")
	public String getUpdateProductPage(@PathVariable Long id,Model model) {
		Product product=productService.findProductById(id);
		model.addAttribute("product", product);
		return "update-product";
	}
	
	@PostMapping("/update")
	@PreAuthorize("hasAnyAuthority('Admin','Prevl_User')")
	public String updateProduct(Product product) {
		 productService.updateProduct(product);
		 return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/";
	}
	
	@GetMapping("/dashboard/{id}")
	public String getDashboardPage(@PathVariable Long id,Model model) {
		Product product=productService.findProductById(id);
		model.addAttribute("product", product);
		return "dashboard";
	}
	
	@GetMapping("/review/{id}")
	public String getReviewPage(@PathVariable Long id,Model model) {
		Product product=productService.findProductById(id);
		model.addAttribute("product", product);
		return "rating";
		
	}
	
	@PostMapping("/review")
	public String addFeedback(@ModelAttribute("product") Product product) {
		Product updatedProduct=productService.updateProduct(product);
		return "redirect:/";
	}
	
	
}
