package com.quiz.store_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBo;
import com.quiz.lesson02.domain.Store;
import com.quiz.store_list.bo.ReviewBo;
import com.quiz.store_list.domain.Review;

@RequestMapping("/store")
@Controller
public class StoreListController {
	
	@Autowired
	private StoreBo storeBo;
	
	@Autowired
	private ReviewBo reviewBo;
	
	// 1. 가게 목록 화면
	@GetMapping("/store-list-view")
	public String storeListView(Model model) {
		
		List<Store> storeList = storeBo.getStoreList();

		model.addAttribute("storeList", storeList);	
		return "store/storeListView";
	}
	
	
	// 2. 리뷰화면
	@GetMapping("/store-review")
	public String storeReviewView(
			@RequestParam("storeId") int storeId,
		
			Model model) {
		
		List<Review> reviewList = reviewBo.getReviewByStoreId(storeId);
		
		model.addAttribute("reviewList", reviewList);

		
		return "store/storeReviewView";
	}
}
