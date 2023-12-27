package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBo;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBo weatherHistoryBo;
	
	@RequestMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		List<WeatherHistory> weatherHistory = null;
		weatherHistory = weatherHistoryBo.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather_history/weatherListView";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeahtehrView() {
		return "weather_history/addWeatherView";
	}
	
	@PostMapping("/add-view")
	public String addView(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy년 MM월 dd일") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherHistoryBo.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:/weather-history/weather-list-view";
	}
}
