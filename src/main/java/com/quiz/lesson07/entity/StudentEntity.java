package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString //자동으로 오버라이딩해줌, 객체를 출력시 필드값이 보여진다.
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor //파라미터가 없는 생성자
@Builder // setter대신 사용
@Getter
@Table(name = "student") // db의 테이블 이름이 studententity가 아니고 student라고 알려주는것
@Entity // 이 객체는 엔티티다.(jpa - db 통신)
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // 원래 jpa는 카멜말고 언더바로 쓰임, 카멜로 썼을때는 이 어노테이션을 붙여줘야함.
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp //내가 크리에이트엣에 세팅을안해도 자동으로 들어감, createAt이 null 이어도 현재시간으로 저장
	@Column(name = "createdAt", updatable = false) // 업데이트시 시간이 변경되지 않도로 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
