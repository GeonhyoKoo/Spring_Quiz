package com.quiz.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	BookmarkBO bookmarkBO;
	
	
	// 결과 페이지
	@GetMapping("/bookmark-list-view")
	public String bookmarkList(Model model) {
		
		List<Bookmark> list = new ArrayList();
		
		// db select
		list = bookmarkBO.getBookmarkList();
		
		// model
		model.addAttribute("list", list);
		
		return "lesson06/afterBookmarkList";
	}
	
	
	// 즐겨찾기 추가하기 페이지
	@GetMapping("/add-bookmark-view")
	public String bookmarkAdd() {
		return "lesson06/addBookmark";
	}
	
	
	// AJAX - return string
	// @Responsebody가 사용되면 Model을쓸 수 없다.
	// MVC기에 View가 있어야만 Model을 쓸 수 있다.
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String , Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		// parameter check! -> ok
		
		// db insert
		bookmarkBO.addBookmarkList(name, url);
		
		// 성공 여부 JSON String
		// javascript 입장에선 아래 내용이 string으로 보인다
		// "{"code":200, "result":"성공"}"
		Map<String , Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	// url 중복 확인 -> ajax 요청
	@ResponseBody
	@PostMapping("/is-duplicate-url")
	public Map<String , Object> isDuplicateUrl(
			@RequestParam("url") String url
			){
		
		// db select
		boolean isDuplicate = bookmarkBO.isDuplicateUrl(url);
		
		
		// 응답
		Map<String , Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicate" , isDuplicate);
		
		
		return result;
	}
	
	// id 로 삭제 -> ajax 요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String , Object> deleteBookmark(
			@RequestParam("id") int id
			){
		
		// db delete
		bookmarkBO.deleteBookmarkById(id);
		
		Map<String , Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
}
