package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBo;
import com.quiz.lesson02.domain.Store;

@RestController // @Controller + @ResponseBody
public class Lesson02Quiz01RestController {

	@Autowired
	private StoreBo storeBo;
	
	// url: http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {  // 리스트의 모든 하나하나의 행들을 리턴하는것 (Store 테이블만든것)
		return storeBo.getStoreList();
	}
}
