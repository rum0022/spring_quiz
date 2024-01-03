package com.quiz.lesson06;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		List<Booking> bookingList = bookingBo.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	@ResponseBody
	@Delete("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		//db
		int rowCount = bookingBo.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200); //성공
			result.put("result", "성공");	
		} else {
			result.put("code", 500); //성공
			result.put("error_message", "삭제하는데 실패했습니다.");
		}
		return result;
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}

	@ResponseBody
	@PostMapping("add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("status") String status) {
		
		//insert DB
		bookingBo.addBooking(name, date, day, headcount, phoneNumber, status);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");		
		//결과값
		return result;
	}
}
