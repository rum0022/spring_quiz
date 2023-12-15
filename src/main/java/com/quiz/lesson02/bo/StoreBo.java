package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service //spring bean
public class StoreBo {

	@Autowired //DI
	private StoreMapper storeMapper;
	
	// input : x => 컨트롤러한테 요청받음.
	// output : List<Store> : store 테이블에 있는 하나하나의 행들의 리스트  => 컨트롤러한테 돌려준다.
	public List<Store> getStoreList() { //스토어의 여러개의 행들을 가져오겠다. 
		return storeMapper.selectStoreList();
	}
}
