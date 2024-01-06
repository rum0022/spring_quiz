package com.quiz.lesson07.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.StudentEntity;
import com.quiz.lesson07.repository.StudentRepository;

@Service
public class StudentBo {

	@Autowired //오토와이어드 어노테이션은 따로따로 써줘야한다.
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(
			String name, String phoneNumber, 
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()  // 객체를 만드는 동시에 세팅까지 해줌 
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략가능 
				.build();
		return	studentRepository.save(student); //entity를 넘겨준다. 이 이후에는 id도 채워짐
	}
	
	// 아래 해놓은건 Mybatis로 insert
}
