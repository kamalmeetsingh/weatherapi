package com.weather.data;

import com.logger.ConsoleLogger;
import com.logger.ILogger;
import com.weather.model.WeatherDetails;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * Class to parse Weather data in JSON format
 * @author kamalmeet.s
 *
 */
public class JsonDataParser implements IDataParser{
	ILogger logger = new ConsoleLogger();
	@Override
	public WeatherDetails parseData(String data) {
		logger.logInfo("recieved for:"+data);
		WeatherDetails weatherDetails = new WeatherDetails();
		try {
			Object obj = new JSONParser().parse(data);
			JSONObject jobject = (JSONObject) obj;
			JSONArray jArr = (JSONArray) jobject.get("list");
			Iterator listitr = jArr.iterator();
			double mintemp = 1000;
			double maxtemp =0;
			boolean isRain = false;
			
			while(listitr.hasNext()) {
				JSONObject val = (JSONObject) listitr.next();
				JSONObject main = (JSONObject) val.get("main");
				double min = (double) main.get("temp_min");
				double max = (double) main.get("temp_max");
				mintemp = Math.min(mintemp, min);
				maxtemp = Math.max(maxtemp, max);
				JSONArray weatherarr = (JSONArray) val.get("weather");
				JSONObject weather = (JSONObject) weatherarr.get(0);
				String rain = (String) weather.get("main");
				if(rain.contains("Rain")) {
					isRain = true;
				}
			}
			String prediction = "";
			if(isRain) {
				prediction = prediction + "Do not forget to carry the umbrella.";
			}
			if(mintemp > 313) {
				prediction = prediction +" Use Sun Screen lotion.";
			}
			weatherDetails.setMaximumTemprature(maxtemp);
			weatherDetails.setMinimumTemprature(mintemp);
			weatherDetails.setPrediction(prediction);
			
		} catch (ParseException e) {
			
			logger.logError(e.getMessage());
		}
		return weatherDetails;
	}

}
