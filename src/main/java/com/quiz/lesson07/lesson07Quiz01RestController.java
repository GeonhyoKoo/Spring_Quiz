package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class lesson07Quiz01RestController {

	
	@Autowired
	private CompanyBO companyBO;
	
	// 1
//	회사명 : 넥손
//	사업내용 : 컨텐츠 게임
//	규모 : 대기업
//	사원수 : 3585명
	
	@GetMapping("/save1")
	public CompanyEntity save1() {

		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	
	
	// 2번
	// 버블팡 규모 -> 중소기업 , 사원수 34  id= 8
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateCompanyById(8 , "중소기업" , 34);
	}
	
	
	// 3번
	// 버블팡 사라짐 id 8
	@GetMapping("/delete")
	public String delete() {
		
		companyBO.delteCompanyById(8);
		
		return "수행 완료";
	}
	
	
	
}
