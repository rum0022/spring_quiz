package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {
	
	@Autowired
	private RealEstateBo realEstateBo;
	
	//url:http://localhost/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		//rentprice = X , 안넣으면 자동으로 null로 된다. (타입이 인티저로 해놨으므로)
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int rowCount = realEstateBo.addRealEstate(realEstate);
		
		return "입력 성공 : " + rowCount; 		
		
	}
	
	//url: http://localhost/lesson03/quiz02/2?realtor_id=5
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam(value = "realtor_id") int realtorId) {
		int rowCount = realEstateBo.addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공:" + rowCount;
	}
}
