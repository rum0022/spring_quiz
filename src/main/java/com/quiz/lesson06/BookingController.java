package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@GetMapping("/booking-list-view")
	public String bookingListView() {
		
		return "booking/bookingList";
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		
		return "booking/makeBooking";
	}

}
