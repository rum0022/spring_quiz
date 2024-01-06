package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.StudentBo;
import com.quiz.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBo studentBo;
	
	// C:create
	@GetMapping("/ex01/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "bada@naver.com";
		String dreamJab = "개발자";
		
		// 방금 인서트된 pk id도 바로 얻어낼 수 있다. 
		 return studentBo.addStudent(name, phoneNumber, email, dreamJab);
	}

}
