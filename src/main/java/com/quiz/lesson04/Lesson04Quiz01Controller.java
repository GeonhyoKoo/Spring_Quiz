package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// @GetMapping("add-seller-view")
	@RequestMapping(path = "/add-seller-view" , method=RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller"; // view 경로
	}
	
	
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature
			// @RequestParam(value = "temperature" , defaultValue = "36.5") double temperature
			) {
		
		sellerBO.addSeller(nickname, temperature, profileImageUrl);
	
		
		return "lesson04/afterAddSeller";
	}
	
	
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id" , required = false) Integer id,
			Model model) {
		
		// DB select
		// id == null 최신
		// id == 3 id로
		Seller seller = null;
		if (id == null) {
			seller  = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// Model 
		model.addAttribute("title", "판매자 정보");
		model.addAttribute("seller", seller);
		
		// 화면 이동
		return "lesson04/sellerInfo";
	}
	
	
	
	
}
