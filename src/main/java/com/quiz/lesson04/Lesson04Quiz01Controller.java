package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBo;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBo sellerBo;
	
	//url: http://localhost/lesson04/quiz01/add-seller-view
	@RequestMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}

	// 회원가입 insert
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value = "temperature", required=false) Double temperature) {
		
		sellerBo.getSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterSeller";
	}
	
	//url: http://localhost/lesson04/quiz01/seller-info
	@GetMapping("/seller-info")
	public String sellerInfo(Model model) { //Model : view화면에 데이터를 넘겨주는 객체
		//DB select(최신가입자)
		Seller seller = sellerBo.getSellerInfo();
		
		//Model 주머니에 데이터를 담는다.=> jsp에서 꺼내쓴다.
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자정보");
		
		return "lesson04/sellerInfo";
	}
}
