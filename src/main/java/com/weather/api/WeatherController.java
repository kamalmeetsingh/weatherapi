package com.weather.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.ConsoleLogger;
import com.logger.ILogger;
import com.weather.model.WeatherDetails;
import com.weather.service.WeatherService;

/**
 * Controller class providing APIs for weather handler 
 * @author kamalmeet.s
 *
 */
@RestController
@RequestMapping("weather")
public class WeatherController {

	static ILogger logger = new ConsoleLogger();
	/**
	 * Method that takescity and returns weather details
	 * @param city
	 * @return
	 */
	@GetMapping("/{city}")
	public WeatherDetails getWeatherDetails(@PathVariable("city") String city) {
		logger.logInfo("Recieved API request for :"+city);
		WeatherDetails weatherDetails = new WeatherService().getWeatherDetails(city);
		return weatherDetails;
	}
}
