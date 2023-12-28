package com.quiz.store_list.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.store_list.domain.Review;



@Repository
public interface ReviewMapper {

	public List<Review> selectReviewByStoreId(int storeId);
}
