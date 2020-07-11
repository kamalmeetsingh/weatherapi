package com.weather.model;

/**
 * Model class to manager Weather Details data
 * @author kamalmeet.s
 *
 */
public class WeatherDetails {

	String prediction;
	double minimumTemprature;
	double maximumTemprature;
	
	public double getMinimumTemprature() {
		return minimumTemprature;
	}

	public void setMinimumTemprature(double minimumTemprature) {
		this.minimumTemprature = minimumTemprature;
	}

	public double getMaximumTemprature() {
		return maximumTemprature;
	}

	public void setMaximumTemprature(double maximumTemprature) {
		this.maximumTemprature = maximumTemprature;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	
	
}
