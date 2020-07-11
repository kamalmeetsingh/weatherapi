package com.logger;

/**
 * Logging interface mentioning core logging details
 * @author kamalmeet.s
 *
 */
public interface ILogger {

	/**
	 * Method to log Information
	 */
	public void logInfo(String message);
	
	/**
	 * Method to log Error
	 */
	public void logError(String message);
	
	/**
	 * Method to log Warning
	 */
	public void logWarning(String message);
	
}
