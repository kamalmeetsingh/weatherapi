package com.logger;

public class ConsoleLogger implements ILogger{

	@Override
	public void logInfo(String message) {
		System.out.println("Info:"+message);
		
	}

	@Override
	public void logError(String message) {
		System.out.println("Error:"+message);
		
	}

	@Override
	public void logWarning(String message) {
		System.out.println("Warning:"+message);
		
	}

}
