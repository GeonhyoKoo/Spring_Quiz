package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller // Spring bean 등록
public class Lesson01Quiz01Controller {

	// 컨트롤러는 요청과 응답을 다 할 수 있음
	
	@RequestMapping("/1")
	@ResponseBody // + return String -> HTML
	public String quiz_01() {
		return "<h2>테스트 프로젝트 완성</h2><h4>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h4>";
	}
	
	
	@RequestMapping("/2")
	@ResponseBody // + return Map -> JSON (jackson library 가 동작)
	public Map<String, Object> quiz_02(){
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map;
	}
	
	
	
}
