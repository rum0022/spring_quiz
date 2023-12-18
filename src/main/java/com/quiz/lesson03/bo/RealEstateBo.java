package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBo {

	//input : id   output:RealEstate(있거나 또는 null)
	@Autowired // DI : spring bean 객체
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstate(id);
	}
	
	//input : rentprice    output:List<RealEstate> ([] or 채워져있거나)
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstatebyAreaPrice(String area, int price) {
		return realEstateMapper.selectRealEstateAreaPrice(area, price);
	}
}
