package com.quiz.lesson07.repository;

import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository { //어떤 엔티티이고, pK의 자료형은 무엇인가
	@PersistenceContext
	private EntityManager em;
	
	public StudentEntity save(StudentEntity studentEntity) {
		em.persist(studentEntity);
		return studentEntity;
	}
	
	
	
}
