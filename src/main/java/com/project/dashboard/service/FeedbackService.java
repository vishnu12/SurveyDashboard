package com.project.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.project.dashboard.model.Feedback;
import com.project.dashboard.repository.FeedbackRepository;

import jakarta.transaction.Transactional;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	public List<Feedback> getAllFeedbacks(){
		return feedbackRepository.findAll();
	}
	
	public Feedback save(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	
	@Transactional
	public List<Feedback> getAllFeedsForProd(Long prodId){
		return feedbackRepository.getAllFeedsForProd(prodId);
	}
	
	public void deleteFeedbackByProdId(Long id) {
		feedbackRepository.deleteByProdId(id);
	}
	
}
