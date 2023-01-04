package com.project.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("feedback")
	public Feedback getFeedback() {
		return new Feedback();
	}

	@GetMapping("/{id}")
	public String showRatingPage(@PathVariable Long id,Model model) {
		Product product=productService.findProductById(id);
		model.addAttribute("product", product);
		return "rating";
		
		
	}
	
	@PostMapping("/add")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		Feedback savedFeedback=feedbackService.save(feedback);
		return "redirect:/";
	}
}
