package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {

	
	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String,Object>> quiz02_1(){
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 0);
		map1.put("director", "로베르토 베니니");
		map1.put("time", 116);
		map1.put("title", "인생은 아름다워");
		list.add(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 12);
		map2.put("director", "크리스퍼 놀란");
		map2.put("time", 147);
		map2.put("title", "인셉션");
		list.add(map2);
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", 19);
		map3.put("director", "윤종빈");
		map3.put("time", 133);
		map3.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(map3);
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 15);
		map4.put("director", "프란시스 로렌스");
		map4.put("time", 137);
		map4.put("title", "헝거게임");
		list.add(map4);
		
		return list;
	}
	
	
	
	// json 출력
	// 게시판 내용을 저장한 json을 List 와 Class 를 설계하고 활용해서 아래와 같이 출력하세요.
	// 요청 URL : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Writing> quiz02_2() {
		
		// @ResponseBody + return String -> HttpMessageConverter -> HTML
		// HttpMessageConverter 때문에 String 이 HTML로 변환 
		// @ResponseBody + return 객체 -> HttpMessageConverter -> Jackson lib -> JSON
		
		List<Writing> list = new ArrayList<>();
		Writing p1 = new Writing();
		p1.setTitle("안녕하세요 가입인사 드립니다.");
		p1.setUser("marobiana");
		p1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		list.add(p1);
		Writing p2 = new Writing();
		p2.setTitle("헐 대박");
		p2.setUser("bada");
		p2.setContent("오늘 목요일이였어... 금요일인줄");
		list.add(p2);
		Writing p3 = new Writing();
		p3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		p3.setUser("dulumary");
		p3.setContent("...");
		list.add(p3);
		return list; // json response body
		
	}
	
	
	// 3 
	// 아래와 같이 게시글 내용을 하나만 json 으로 출력하세요.
	// ResponseEntity 를 이용해서 HttpStatus.INTERNAL_SERVER_ERROR 로 상태 코드를 전달하세요
	@RequestMapping("/3")
	public ResponseEntity<Writing> quiz02_3() {
		
		Writing write = new Writing();
		write.setTitle("안녕하세요 가입인사 드립니다.");
		write.setUser("marobiana");
		write.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");

		return new ResponseEntity<>(write, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
