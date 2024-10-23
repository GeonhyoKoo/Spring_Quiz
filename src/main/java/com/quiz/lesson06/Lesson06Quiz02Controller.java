package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/add-bookmark-view2")
	public String addBookmarkView() {
		return "lesson06/addBookmark2";
	}
	
	
	@ResponseBody
	@GetMapping("/is-duplicated-url")
	public Map<String , Object> isDuplicatedUrl(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			){
		
		// db select : url
		boolean isDuplicate =  bookmarkBO.isDuplicatedUrl(url);
		
		// {"code" : 200 , "is_duplicated_url" : true}
		Map<String , Object> result = new HashMap<>();
		
		if(isDuplicate) {
			result.put("code" , 400);
			result.put("is_duplicated_url" , isDuplicate);
			return result;
		} 
		
		// db insert
		bookmarkBO.addBookmarkList(name, url);
		
		result.put("code", 200);
		result.put("is_duplicated_url" , isDuplicate);
		
		return result;
	}

	@ResponseBody
	@PostMapping("/delete-bookmark")
	public String deleteBookmark() {
		
		
		
		
		return "redirect:/lesson06/quiz02/book-mark-List2";
	}
	
	
	@GetMapping("/book-mark-List2")
	public String bookmarkList2(Model model) {
		
		// db select 
		List<Bookmark> result = bookmarkBO.getBookmarkList();
		
		
		// model
		model.addAttribute("result", result);
		
		
		return "lesson06/afterBookmarkList2";
	}
	
	
}
