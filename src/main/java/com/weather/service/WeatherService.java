package com.weather.service;

import com.weather.data.WeatherData;
import com.weather.model.WeatherDetails;

/**
 * Service class to handle Weather related operations
 * @author kamalmeet.s
 *
 */
public class WeatherService {
	
	/**
	 * Method to fetch weather details
	 * @param city
	 */
	public WeatherDetails getWeatherDetails(String city) {
		WeatherDetails weatherDetails = new WeatherData().getWeatherDetails(city);
		return weatherDetails;
	}

}
