package com.quiz.lesson06;

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

import com.quiz.lesson06.bo.BookingBo;
import com.quiz.lesson06.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBo bookingBo;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		//select DB
		List<Booking> bookingList = bookingBo.getBookingList();
		//model에 담기
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// 삭제 - AJAX요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// Delete db
		int rowCount = bookingBo.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200); //성공
			result.put("result", "성공");	
		} else {
			result.put("code", 500); //실패
			result.put("error_message", "삭제하는데 실패했습니다."); //서버에서 실패
		}
		return result;
	}
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}

	// 예약하기 -AJAX 요청
	@ResponseBody
	@PostMapping("/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date, //String으로 둬도됨
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		//insert DB
		bookingBo.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");		
		//결과값
		return result;
	}
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	@ResponseBody
	@PostMapping("/select-booking")
	public Map<String, Object> selectBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			Model model) {
		
		// {"code":200, result:booking객체}
		// {"code":200, "result":{"name":"신보람",...}
		Map<String, Object> result = new HashMap<>();
		
		Booking booking = bookingBo.getBookingByNamePhoneNumber(name, phoneNumber);
		if (booking == null) { // 아무것도 리턴될게 없다면
			// {"code":500, "error_message":"예약내역이 존재하지 않습니다."}
			result.put("code", 500);
			result.put("error_message", "예약내역이 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
		}
		
		return result;
	}

}