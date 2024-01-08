package com.quiz.store_list.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.store_list.domain.Review;



@Mapper
public interface ReviewMapper {

	public List<Review> selectReviewByStoreId(int storeId);
}
