package com.project.dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dashboard.model.Feedback;
import com.project.dashboard.model.Product;
import com.project.dashboard.repository.FeedbackRepository;
import com.project.dashboard.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private ProductRepository productRepository;

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
	
    public Map<String,Integer> dataProviderForCards(Long prodId) {
		List<Feedback> feedbacks=feedbackRepository.getAllFeedsForProd(prodId);
		Map<String,Integer> map=new HashMap<String,Integer>();
		
			int vfm=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getValueForMoney(),Integer::sum);
			int fit=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getFit(),Integer::sum);
			int quality=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getQuality(),Integer::sum);
			int delivery=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getDelivery(),Integer::sum);
			int service=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getService(),Integer::sum);
			map.put("valueForMoney",vfm);
			map.put("fit", fit);
			map.put("quality", quality);
			map.put("delivery", delivery);
			map.put("service", service);
			map.put("size", feedbacks.size()==0?1:feedbacks.size());
			
			return map;
		
		
	}   
    
    public Map<String,Integer> dataProviderForBarChart(){
    	List<Product> products=productRepository.findAll();
    	Map<String,Integer> data=new TreeMap<>();
    	for(Product product:products) {
    		List<Feedback> feedbacks=feedbackRepository.getAllFeedsForProd(product.getId());
    		int size=feedbacks.size()==0?1:feedbacks.size();
    		int vfm=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getValueForMoney(),Integer::sum);
			int fit=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getFit(),Integer::sum);
			int quality=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getQuality(),Integer::sum);
			int delivery=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getDelivery(),Integer::sum);
			int service=feedbacks.stream().reduce(0,(a,b)->a+(int)b.getService(),Integer::sum);
		    data.put(product.getName(), vfm+fit+quality+delivery+service/25*size);
    	}
    	
    	return data;
    	
    }
    
	
}
