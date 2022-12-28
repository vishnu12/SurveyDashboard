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
	
	private Set<String> valueForMoney=new HashSet<>();
	
	private Set<String> quality=new HashSet<>();
	
	private Set<String> fit=new HashSet<>();

	public Feedback(long id, Set<String> valueForMoney, Set<String> quality,
			Set<String> fit) {
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
