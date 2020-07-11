package com.weather.data;

import com.weather.model.WeatherDetails;

/**
 * Data Layer class for Weather 
 * @author kamalmeet.s
 *
 */
public class WeatherData {
	
	public WeatherDetails getWeatherDetails(String city) {
		// TODO fetch weather details
		WeatherDetails weatherDetails = DataUtility.getDetailsForCity(city);
		//weatherDetails.setPrediction("Don't forget to carry the umbrella");
		return weatherDetails;
	}

}
