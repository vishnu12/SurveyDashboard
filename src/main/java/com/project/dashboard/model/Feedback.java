package com.project.dashboard.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedbacks")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long prodId;
	
	private double valueForMoney;
	
	private double quality;
	
	private double fit;
	
	private double delivery;
	
	private double service;

	public Feedback(long id, long prodId, double valueForMoney, double quality, double fit, double delivery,
			double service) {
		super();
		this.id = id;
		this.prodId = prodId;
		this.valueForMoney = valueForMoney;
		this.quality = quality;
		this.fit = fit;
		this.delivery = delivery;
		this.service = service;
	}

	public Feedback() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public double getValueForMoney() {
		return valueForMoney;
	}

	public void setValueForMoney(double valueForMoney) {
		this.valueForMoney = valueForMoney;
	}

	public double getQuality() {
		return quality;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public double getFit() {
		return fit;
	}

	public void setFit(double fit) {
		this.fit = fit;
	}

	public double getDelivery() {
		return delivery;
	}

	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}

	public double getService() {
		return service;
	}

	public void setService(double service) {
		this.service = service;
	}

	
}
