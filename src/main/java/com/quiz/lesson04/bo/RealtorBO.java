package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {

	@Autowired
	private RealtorMapper realtorMapper;
	
	public void addRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	public Realtor selectRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
	
	
}
