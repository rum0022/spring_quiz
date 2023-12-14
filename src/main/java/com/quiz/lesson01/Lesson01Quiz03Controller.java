package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//JSP 파일로 보낼때는 @Controller만 사용
@Controller // @ResponseBody 없음
public class Lesson01Quiz03Controller {

	// url:http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1") //Request url path
	public String quiz03() {
		//@ResponseBody가 아닌 단독으로 사용되는 @Controller + return String
		// ViewResolver에 의해서 리턴된 String의 jsp경로를 찾고 화면이 구성된다. => HTML 응답(Response Body)
		return "lesson01/quiz03"; //jsp경로
	}
}
