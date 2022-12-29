package com.project.dashboard.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="feedbacks")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String valueForMoney;
	
	private String quality;
	
	private String fit;

	
	public Feedback(long id, String valueForMoney, String quality, String fit) {
		super();
		this.id = id;
		this.valueForMoney = valueForMoney;
		this.quality = quality;
		this.fit = fit;
	}


	public Feedback() {
		super();
	}
	
	

}
