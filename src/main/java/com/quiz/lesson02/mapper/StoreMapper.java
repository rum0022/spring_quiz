package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Review;
import com.quiz.lesson02.domain.Store;

@Repository //spring bean
public interface StoreMapper {
	
	// input : x => BO한테 요청받음.
	// output : List<Store> : store 테이블에 있는 하나하나의 행들의 리스트  => BO한테 돌려준다.
	public List<Store> selectStoreList(); //구현이 없는 인터페이스므로 ;로 닫아준다. 
	
	public Review selectReviewByStoreId(int storeid);
}
