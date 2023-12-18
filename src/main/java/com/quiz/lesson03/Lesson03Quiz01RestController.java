package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBo realEstateBo;
	
	//url:http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value = "id") int id) {
		return realEstateBo.getRealEstateById(id);
	}
	
	//url:http://localhost/lesson03/quiz01/2?rent_price=90
	//단건인지 여러건인지 확인후에 타입 지정해야함 !! 여기서는 list이다.
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value = "rent_price") int rentPrice) {
		return realEstateBo.getRealEstateListByRentPrice(rentPrice);
	}
	
	//url:http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam(value = "area") String area, 
			@RequestParam(value = "price") int price) {
		return realEstateBo.getRealEstatebyAreaPrice(area, price);
	}
}
