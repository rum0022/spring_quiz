package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void addBooking(String name, String date, int day, 
			int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	//없으면 null 있으면 객체리턴
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		// 없는 경우: []    , 있는경우 [....]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		// 리스트를 뽑으면 과거순부터 최신순으로 되어있지만 우리는 최신순 하나를 뽑아야하므로
//		if (bookingList.isEmpty()) {
//			return null;
//		} 
//		return bookingList.get(bookingList.size() - 1); //마지막 인덱스
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
