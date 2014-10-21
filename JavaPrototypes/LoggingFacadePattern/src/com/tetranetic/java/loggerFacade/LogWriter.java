package com.tetranetic.java.loggerFacade;

public interface LogWriter {
	LogStatus log(String fqdn, String message, AppLogger appLogger, LogType logType);
	LogStatus log(String fqdn, String message, AppLogger appLogger, LogType logType, Throwable throwable);
}
