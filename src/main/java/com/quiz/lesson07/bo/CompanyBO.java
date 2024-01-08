package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity addCompany(
			String name, String business, 
			String scale, int headcount) {
		
		return companyRepository.save(CompanyEntity.builder()
										.name(name)
										.business(business)
										.scale(scale)
										.headcount(headcount)
										.build());
	}
	
	// update
	public CompanyEntity updateCompanyBusinessHeadCountById(
			int id, String scale, int headcount) {
		
		// select
		CompanyEntity company = companyRepository.findById(id).orElse(null); //id를 가져왔는데 없으면 null로 하겠다. 
		
		// update 
		if (company != null) {
			company = company.toBuilder()
							.scale(scale)
							.headcount(headcount)
							.build();
		}
		
		// save
		company = companyRepository.save(company);
		return company;
	}
	
	// delete
	public void deleteCompanyById(int id) {
		//select
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		// if(있으면 수행해라 c(엔티티객체)는 아무이름으로 해도 상관없음)
		companyOptional.ifPresent(c -> companyRepository.delete(c)); // c(CompanyEntity가 존재한다면 삭제해라)
	}
}
