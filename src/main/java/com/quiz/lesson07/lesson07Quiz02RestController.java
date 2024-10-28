package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class lesson07Quiz02RestController {

	
	@Autowired
	private RecruitRepository recruitRepository;
	
	// 1 
	// id로 조회  id = 8
	@GetMapping("/1")
	public RecruitEntity select1(){
		return recruitRepository.findById(8).orElse(null);
	}
	
	
	// 2
	// 성남시 분당구에 위치한것들 
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId
			){
		return recruitRepository.findByCompanyId(companyId);
	}
	
	// 3
	// 웹 back end 개발자 and 정규직
	@GetMapping("/3")
	public List<RecruitEntity> select3(){
		return recruitRepository.findByPositionAndType("웹 back-end 개발자" , "정규직");
	}
	
	// 4
	// 정규직 이거나 연봉이 9000 이상인 공고
	@GetMapping("/4")
	public List<RecruitEntity> select4(){
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직" , 9000);
	}
	
	// 5
	// 계약직 목록에서 연봉 기준으로 내림차순 3개
	@GetMapping("/5")
	public List<RecruitEntity> select5(){
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	// 6
	// 성남시 분당구이고 연봉이 7000 >= 8500 <=
	@GetMapping("/6")
	public List<RecruitEntity> select6(){
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000 , 8500);
	}
	
	
	// 7
	// 마감일 2026-04-10 이후 , 연봉이 8100 이상, 정규직 , 연봉 내림차순
	@GetMapping("/7")
	public List<RecruitEntity> select7(){
		//return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderbySalaryDesc(
			//	"2026-04-10" , 8100 , "정규직");
		
		return recruitRepository.findCondition("2026-04-10" , 8100 , "정규직");
		
	}
	
	
	
}
