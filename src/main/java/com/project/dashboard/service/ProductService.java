package com.project.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.dashboard.model.Feedback;
import com.project.dashboard.model.Product;
import com.project.dashboard.repository.FeedbackRepository;
import com.project.dashboard.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Product findProductById(Long id) {
		return productRepository.getById(id);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public void deleteProductById(Long id) {
		feedbackRepository.deleteByProdId(id);
		productRepository.deleteById(id);
	}
	

}
