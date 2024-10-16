package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@Autowired
	WeatherHistoryBO weatherHistoryBO;
	
	// 목록
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// list select
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherList", weatherList);
		
		return "weather_history/weatherList";
	}
	
	
	// 추가
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		
		
		return "weather_history/addWeather";
	}
	
}
