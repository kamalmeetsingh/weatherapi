package com.weather.data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.logger.ConsoleLogger;
import com.logger.ILogger;
import com.weather.model.WeatherDetails;

/**
 * Utility class to manager Data related utility functions
 * @author kamalmeet.s
 *
 */
public class DataUtility {
	static ILogger logger = new ConsoleLogger();
	/**
	 * Utility method to fetch city related weather details
	 * @param city
	 * @return
	 */
	public static WeatherDetails getDetailsForCity(String city) {
		HttpClient client = HttpClient.newHttpClient();
		String url = Config.WeatherEndpoint + "&q="+city;
		logger.logInfo("Requesting for :"+ url);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException ex) {
			logger.logError(ex.getMessage());
		} catch (InterruptedException ex) {
			logger.logError(ex.getMessage());
		}
		IDataParser dataParser = new JsonDataParser();
		return dataParser.parseData(response.body());
	}
}
