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
	
	// 날씨 목록 화면
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBo.getWeatherHistoryList();
		model.addAttribute("weatherHistory", weatherHistoryList);
		return "weather_history/weatherListView";
	}
	
	//날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeahtehrView() {
		return "weather_history/addWeatherView";
	}
	
	// 날씨 추가 수행 => 날씨목록화면으로 이동
	@PostMapping("/add-weather")
	public String addWeather(
			// insert, select에서 date는 String이나 Date로 둘다 받아와도 상관없음.
			// Date 그대로 하고 싶으면 @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")( 패턴은 이렇게 들어올거야 )Date date
			// 객체 WeatherHistory weatherHistory로 받고 싶으면 도메인 Date위에 @DateTimeFormat(pattern = "yyyy-MM-dd")이걸 써놔도됨
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		//db insert
		weatherHistoryBo.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		//결과화면 => 리다이렉트 302
		//1번 : HttpServletRequest request 로 호출하기 (서블릿처럼)
		//2번 : redirect:/path 쓰기
		return "redirect:/weather-history/weather-list-view";
	}
}
