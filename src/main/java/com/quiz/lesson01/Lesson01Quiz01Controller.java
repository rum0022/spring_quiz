package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller //spring bean 등록
public class Lesson01Quiz01Controller {
	
	// url: http://localhost:8080/lesson01/quiz01/1
	@ResponseBody
	@RequestMapping("/1")
	public String quiz01_1() {
		return "<h2>테스트 프로젝트 완성</h2>" + "<h3>해당 프로젝트를 통해서 문제풀이를 진행합니다.</h3>";
	}
	
	
	// url: http://localhost:8080/lesson01/quiz01/2
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> quiz01_2() {
		
		Map<String, Object> subject = new HashMap<>();
		subject.put("국어", 80);
		subject.put("수학", 90);
		subject.put("영어", 85);
		
		return subject;
	}
	
	
}
