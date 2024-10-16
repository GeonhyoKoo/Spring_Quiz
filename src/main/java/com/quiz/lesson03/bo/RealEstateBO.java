package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	
	// 1
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	
	//2 
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// 3
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price) {
		return realEstateMapper.selectRealEstateByAreaandPrice(area, price);
	
	}
	
	// 4
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	//5 
	public int addRealEstateAsField(int realtorId, String address,
			int area, String type, int price, int rentPrice) {
		
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	//quiz03
	public int updateRealEstateById(int id, String type, int price) {
		 return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	//quiz04
	public void deleteRealEstateById(int id) {
		realEstateMapper.deleteRealEstateById(id);
	}
	
}
