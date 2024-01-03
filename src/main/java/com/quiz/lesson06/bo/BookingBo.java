package com.quiz.lesson06.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.domain.Booking;
import com.quiz.lesson06.mapper.BookingMapper;

@Service
public class BookingBo {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}

	public void addBooking(String name, String date, int day, int headcount, String phoneNumber, String status) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber, status);
	}
}
