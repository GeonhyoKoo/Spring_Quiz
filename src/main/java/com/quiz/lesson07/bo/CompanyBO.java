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
	
	// 1
	public CompanyEntity addCompany(String name,
			String business, String scale, int headcount) {
		
		CompanyEntity company = CompanyEntity.builder().name(name).business(business)
				.scale(scale).headcount(headcount).build();
		
		return companyRepository.save(company);
	}
	
	
	// 2 update
	public CompanyEntity updateCompanyById(int id , String scale , int headcount) {
		
		// id로 조회하기
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// null 인지 확인
		if (company != null) {
			companyRepository.save(company.toBuilder().scale(scale).headcount(headcount).build());
		}
		
		return company;
	}
	
	// 3 delete
	public void delteCompanyById(int id) {
		
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
		
	}
	
	
}
