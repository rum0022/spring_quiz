package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBo;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBo realtorBo;
	
	//첫화면
	//url:http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	//url:http://localhost:8080/lesson04/quiz02/add-realtor
	// insert -> jsp뿌리기
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, // 파라미터가 잘 세팅됐는지 먼저확인(대박공인 등등)
			Model model) {
		
		// insert => 방금 추가된 pk받아옴 => realtor에 세팅
		realtorBo.addRealtor(realtor);
		
		//DB에서 방금 가입된(realtor에 세팅된 id로 객체 다시조회) 사용자 select
		Realtor latestRealtor = realtorBo.getRealtorById(realtor.getId());
		
		//model
		model.addAttribute("realtor", latestRealtor);
		model.addAttribute("title", "공인중개사 추가");
		return "lesson04/afterAddRealtor";
	}
}
