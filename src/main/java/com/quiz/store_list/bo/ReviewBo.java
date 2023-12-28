package com.quiz.store_list.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.store_list.domain.Review;
import com.quiz.store_list.mapper.ReviewMapper;


@Service
public class ReviewBo {

	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Review> getReviewByStoreId(int storeId) {
		return reviewMapper.selectReviewByStoreId(storeId);
	}
}
