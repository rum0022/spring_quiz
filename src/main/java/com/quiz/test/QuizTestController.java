package com.quiz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizTestController {

	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		return "<h2>Hello World!<h2>";
	}
}
