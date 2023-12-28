package com.quiz.store_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBo;
import com.quiz.lesson02.domain.Review;
import com.quiz.lesson02.domain.Store;

@RequestMapping("/store")
@Controller
public class StoreListController {
	
	@Autowired
	private StoreBo storeBo;
	
	@GetMapping("/store-list-view")
	public String storeListView(Model model) {
		
		List<Store> stores = null;
		stores = storeBo.getStoreList();
		
		model.addAttribute("stores", stores);
		return "store/storeListView";
	}
	
	@GetMapping("/store-review")
	public String storeReviewView(
			@RequestParam("storeId") int storeId,
			Model model) {
		
		Review reviews = storeBo.getReviewByStoreId(storeId);
		
		
		model.addAttribute("reviews", reviews);
		return "store/storeReviewView";
	}
}
