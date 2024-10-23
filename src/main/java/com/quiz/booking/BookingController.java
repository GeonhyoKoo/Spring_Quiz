package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
public class BookingController {

	@Autowired
	BookingBO bookingBO;
	
	// 홈페이지 메인 화면
	@GetMapping("/logpension")
	public String logPension() {
		return "booking/logPension";
	}
	
	// 예약 목록 확인 화면
	@GetMapping("/booking/booking-list-view")
	public String bookingListView(Model model) {
		
		// db select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model 
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// delete -> ajax
	@DeleteMapping("/delete-booking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id
			){
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// data
		Map<String , Object> result = new HashMap<>();
		
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "success");
		} else {
			result.put("code", 400);
			result.put("error_message", "삭제할 대상이 없습니다.");
		}
		
		return result;
	}
	
	@GetMapping("/booking/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	
	
	@ResponseBody
	@PostMapping("/booking/make-booking")
	public Map<String , Object> makeBooking(
			@RequestParam("name") String name, 
			@RequestParam("date") LocalDate date, 
			@RequestParam("day") int day, 
			@RequestParam("headcount") int headcount, 
			@RequestParam("phoneNumber") String phoneNumber
			){
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// response Json
		Map<String , Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;
	}
	
	
	
	// 예약 조회
	@ResponseBody
	@PostMapping("/booking/check-booking")
	public Map<String , Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber
			){
		
		// db select
		Booking booking  = bookingBO.getLatestBookingByNameAndPhoneNumber(name, phoneNumber);
		
		// response
		// {"code" : 200 , "result" : booking}
		// {"code" : 200 , "result" : {"id" : 3 , "name" : "" ...}}
		Map<String , Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			// 한개 씩 넣는 방법도 있지만 한번에 보내는게 낫다.
//			result.put("name", booking.getName());
//			result.put("date", booking.getDate());
//			result.put("day", booking.getDay());
//			result.put("headcount", booking.getHeadcount());
//			result.put("state", booking.getState());
			result.put("result", booking);
		} else {
			result.put("code", 400);
			result.put("error_mesage", "예약 내역이 없습니다");
		}
		
		return result;
	}
	
	
	
	
}
