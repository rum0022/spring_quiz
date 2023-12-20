package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;

@RestController
public class Lesson03quiz04Restcontroller {

	@Autowired
	private RealEstateBo realEstateBo;
	
	// url: http://localhost:8080/lesson03/quiz04/1?id=21
	@RequestMapping("/lesson03/quiz04/1")
	public String quiz04_1(
			@RequestParam("id") int id) {
		
		int rowCount = realEstateBo.deleteRealEstateById(id);
		return "삭제 성공: " + rowCount;
	}
}
