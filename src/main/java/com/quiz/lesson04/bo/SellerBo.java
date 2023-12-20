package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBo {

	@Autowired
	private SellerMapper sellerMapper;
	
	public void getSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// input: x            output: Seller 최신 (있거나 or null)
	public Seller getSellerInfo() {
		return sellerMapper.selectSellerInfo();
	}
}
