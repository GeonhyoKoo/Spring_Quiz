package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	BookingMapper bookingMapper;
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name , LocalDate date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input : name , phoneNumber
	// output : Booking(최신의 데이터) or null
	public Booking getLatestBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		
		List<Booking> bookingList =  bookingMapper.selectBookingListByNameAndPhoneNumber(name, phoneNumber);
		// [1, 2] or [1]
		// []
		
//		if (bookingList.isEmpty()) {
//			return null;
//		}
//		
//		// 마지막 칸 : 요소 개수 -1
//		return bookingList.get(bookingList.size()-1);
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size()-1);
	}
	
}
