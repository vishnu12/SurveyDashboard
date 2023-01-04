package com.project.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.dashboard.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	@Query(value="select * from feedbacks where prod_id =:prodId",nativeQuery = true)
	List<Feedback> getAllFeedsForProd(@Param("prodId") Long prodId);
	
	@Modifying
	@Query(value="delete from feedbacks where prod_id =:prodId",nativeQuery = true)
	void deleteByProdId(@Param("prodId") Long prodId);
	
}
