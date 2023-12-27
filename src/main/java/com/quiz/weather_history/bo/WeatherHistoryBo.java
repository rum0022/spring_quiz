package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBo {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// select
	public List<WeatherHistory> getWeatherHistory() {
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	// insert
	public void addWeatherHistory(Date date, String weather, String microDust, 
		double temperatures, double precipitation, double windSpeed) {
		
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
