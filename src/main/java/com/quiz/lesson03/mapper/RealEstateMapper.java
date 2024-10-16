package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	//1
	public RealEstate selectRealEstateById(int id);
	
	
	//2
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	
	//3
	public List<RealEstate> selectRealEstateByAreaandPrice(int area, int price);
	
	// 파라미터 두개 이상은 원래 xml 못보내서 BO에서 맵으로 만들어서 보냈지만, 어노테이션이 생김
//	public List<RealEstate> selectRealEstateByAreaandPrice(
//			// 하나의 맵으로 구성해야 하는데 , @Param 맵으로 만들어줌
//			@Param("area") int area,
//			@Param("price") int price
//			);
	
	// @Param에 "" 안에 들어간게 키이름이 되기 때문에 xml에선 값을 동일하게 설정해야함.
	
	
	// 1
	public int insertRealEstate(RealEstate realEstate);
	
	// 2
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address,
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice
			);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	//4
	public int deleteRealEstateById(int id);
}
