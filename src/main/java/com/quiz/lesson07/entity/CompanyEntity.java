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

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) 
@Getter // lombok
@Table(name = "company") // db에 저장된 테이블 이름설정을 해야한다.
@Entity //이 객체는 엔티티가 될 것이다. (JPA설정해야함)
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //행이 겹치지 않는 번호로 구성되어있다. 
	private int id;
	
	private String name;
	
	private String business;
	
	private String scale;
	
	private int headcount;
	
	@UpdateTimestamp // null로 들어가있어도 현재시간들어감
	@Column(name = "createdAt", updatable = false) // 만든시간은 고정되어 있어야하므로
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
