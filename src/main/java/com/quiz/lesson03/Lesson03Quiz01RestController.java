package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {

	// 1.
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam("id") int id
			) {
		return realEstateBO.getRealEstateById(id);
	}
	
	
	//2
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value = "rent_price") int rentPrice
			) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	//3
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price
			
			) {
		return realEstateBO.getRealEstateByAreaAndPrice(area, price);
	}
	
	
}
