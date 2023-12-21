package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.RealtorBo;
import com.quiz.lesson04.domain.Realtor;

@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBo realtorBo;
	
	//첫화면
	//url:http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/lesson04/quiz02/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	//url:http://localhost:8080/lesson04/quiz02/add-realtor
	// insert -> jsp뿌리기
	@PostMapping("/lesson04/quiz02/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// insert
		realtorBo.addRealtor(realtor);
		
		//DB에서 방금 가입된 사용자 select
		int id = realtor.getId();
		
		// select
		realtorBo.getRealtorById(id);
		
		//model
		model.addAttribute("realtor", realtor);
		model.addAttribute("title", "공인중개사 추가");
		return "lesson04/afterAddRealtor";
	}
}
