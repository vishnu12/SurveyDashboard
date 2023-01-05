package com.project.dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	
    public Map<String,Integer> dataForPieChart(){
      List<Product> products=productRepository.findAll();
      Map<String,Integer> data=new TreeMap<>();
      for(Product product:products) {
    	  data.put(product.getName(), (int)product.getOrders());
      }
      return data;
    }
	

}
