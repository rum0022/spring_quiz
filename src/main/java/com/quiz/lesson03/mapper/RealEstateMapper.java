package com.quiz.lesson03.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstate(int id);
	
	public List<RealEstate> selectRealEstateListRentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateAreaPrice(String area, int price);
}
