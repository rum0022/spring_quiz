package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstate(int id);
	
	public List<RealEstate> selectRealEstateListRentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// mybatis문법상 파라미터는 단 한개만 xml로 보낼 수 있다.
			// 파라미터들을 하나의 Map에 담아서 보낸다.
			// 맵으로 만들어주는 어노테이션은 @Param 이다.
			@Param("area") int area,
			@Param("price") int price);
	
	//input: RealEstate      output: 행의 개수
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
}
