package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	@PostMapping("/add-weather")
	public String addWeather(
			// date를 string으로 받아도 가능함
			// Date 로 받을 때는 
			// @DateTimeFormat(pattern = "yyyy-MM-dd") 으로 설정을 해주면 받을 수 있다.
			@RequestParam("date") LocalDate date, // String 으로 받는 것도 가능하다. 
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed,
			
			// 이게 없어도 되네?
			RedirectAttributes redirect
			// HttpServletResponse response
			) {
		
		//db insert
		WeatherHistory weatherHistory = new WeatherHistory();
		weatherHistory.setDate(date);
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setPrecipitation(precipitation);
		weatherHistory.setWeather(weather);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setWindSpeed(windSpeed);
		
		weatherHistoryBO.addWeatherHistory(weatherHistory);
		
		
		// response sendRedirect("/weather_history/weather-list-view") 예외처리 해야함.
		
		
		// redirect로 목록 페이지 이동
		return "redirect:/weather_history/weather-list-view";
	}
	
}
