package com.weather.data;

import com.weather.model.WeatherDetails;

/**
 * Parser interface to provide Weather data parsing 
 * @author kamalmeet.s
 *
 */
public interface IDataParser {

	/**
	 * Method to parse wather data
	 * @param data
	 * @return
	 */
	public WeatherDetails parseData(String data);
}
