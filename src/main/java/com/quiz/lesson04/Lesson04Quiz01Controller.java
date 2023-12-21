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
	
	//url: http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller"; //jsp화면으로 출력
	}

	// 회원가입 insert => 입력성공
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		//db insert
		sellerBo.getSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterSeller";
	}
	
	// 최근 가입자 한명 화면 
	//url: http://localhost:8080/lesson04/quiz01/seller-info-view
	//url: http://localhost:8080/lesson04/quiz01/seller-info-view?id=...
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			Model model,
			@RequestParam(value = "id", required = false) Integer id) { //Model : view화면에 데이터를 넘겨주는 객체
		
		//DB select(최신가입자)
		Seller seller = null;
		if (id == null) {
			seller = sellerBo.getSellerInfo();  // id가 없을때
		} else {//select(id)
			//seller = sellerBo.getSellerById(id);
			seller = sellerBo.getSellerById(id); // id가 있을때
		}
	
		
		//Model 주머니에 데이터를 담는다.=> jsp에서 꺼내쓴다.
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자정보");
		
		return "lesson04/sellerInfo";
	}
}
