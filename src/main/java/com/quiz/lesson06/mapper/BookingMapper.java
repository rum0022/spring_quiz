package com.quiz.lesson06.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Booking;

@Repository
public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);

	//input : 이름, 전화번호    output:List<Booking> 입력한 사람이 여러건 예약한 내역이 있을 수 있으므로 리스트로가져오기
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
