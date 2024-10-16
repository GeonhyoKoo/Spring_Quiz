package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	
	@PostMapping("/add-realtor")
	public String addRealtor(@ModelAttribute Realtor realtor, Model model ) {
		
		// db insert
		realtorBO.addRealtor(realtor);
		
		
		// db select
		Realtor latestRealtor = realtorBO.selectRealtorById(realtor.getId());
		
		// model
		model.addAttribute("realtor", latestRealtor);
		
		// view
		return "lesson04/afterRealtor";
	}
	
}
