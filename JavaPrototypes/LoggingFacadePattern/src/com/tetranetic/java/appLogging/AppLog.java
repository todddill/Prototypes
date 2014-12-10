package com.tetranetic.java.appLogging;

import com.tetranetic.java.loggerFacade.AppLogger;
import com.tetranetic.java.loggerFacade.LogStatus;
import com.tetranetic.java.loggerFacade.LogType;
import com.tetranetic.java.loggerFacade.LogWriter;

public class AppLog implements LogWriter {

	@Override
	public LogStatus log(String fqdn, String message, AppLogger appLogger, LogType logType) {
		switch (logType)
		{
			case DEBUG:
				return appLogger.debug(fqdn, message);
			case INFO:
				return appLogger.info(fqdn, message);
			case ERROR:
				return appLogger.error(fqdn, message);
			default:
				return appLogger.fatal(fqdn, message);
		}
	}

	@Override
	public LogStatus log(String fqdn, String message, AppLogger appLogger, LogType logType,
			Throwable throwable) {
		switch (logType)
		{
			case DEBUG:
				return appLogger.debug(fqdn, message, throwable);
			case INFO:
				return appLogger.info(fqdn, message, throwable);
			case ERROR:
				return appLogger.error(fqdn, message, throwable);
			default:
				return appLogger.fatal(fqdn, message, throwable);
		}
	}

}
