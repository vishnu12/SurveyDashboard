package com.project.dashboard.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	private long orders;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "prod_feedbacks",
	joinColumns = @JoinColumn(name="product_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="feedback_id", referencedColumnName = "id"))
	private Set<Feedback> feedback =new HashSet<>();
	

	public Product(long id, String name, String description, long orders) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.orders = orders;
	}

	public Product() {
		super();
	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void addFeedback(Feedback feedback) {
		this.feedback.add(feedback);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOrders() {
		return orders;
	}

	public void setOrders(long orders) {
		this.orders = orders;
	}

	
}
