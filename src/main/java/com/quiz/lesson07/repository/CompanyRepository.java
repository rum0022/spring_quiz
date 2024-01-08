package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// @Transactional 이땐 인터페이스말고 class라고 써야함
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public CompanyEntity save(CompanyEntity companyEntity) {
//		em.persist(companyEntity);
//		return companyEntity;
//	}

	// 이런게 숨어있음
	// Spring data Jpa
	// 엔티티객체 save(엔티티객체);
	// Optional<엔티티객체> findById(id)
}
