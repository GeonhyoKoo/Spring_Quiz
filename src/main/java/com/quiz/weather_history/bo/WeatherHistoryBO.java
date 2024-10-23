package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistory(){
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	public void addWeatherHistory(WeatherHistory weatherHistory ) {
		weatherHistoryMapper.insertWeatherHistory(weatherHistory);
	}
	
}
