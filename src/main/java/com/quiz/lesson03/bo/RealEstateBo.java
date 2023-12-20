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
	
	//input: area, price      output:List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	//input: RealEstate      output: 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	
    public int addRealEstateAsField(
    		int realtorId, 
    		String address, 
    		int area, 
    		String type, 
    		int price, 
    		Integer rentPrice) {
    	
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
    // input : id, type, pride       output: 성공한 행의 개수
    public int updateRealEstateById(int id, String type, int price) {
    	return realEstateMapper.updateRealEstateById(id, type, price);
    }
    
    // input : id             output: 성공한 행의 개수
    public int deleteRealEstateById(int id) {
    	return realEstateMapper.deleteRealEstateById(id);
    }
}
