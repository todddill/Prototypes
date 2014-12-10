package com.tetranetic.java.facades;

import org.apache.log4j.*;

import com.tetranetic.java.loggerFacade.AppLogger;
import com.tetranetic.java.loggerFacade.LogStatus;

public class Log4JFacade implements AppLogger {
	
	@Override
	public LogStatus debug(String fqdn, String message) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).debug(message);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus debug(String fqdn, String message, Throwable throwable) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).debug(message, throwable);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus info(String fqdn, String message) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).info(message);			
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}
	@Override
	public LogStatus info(String fqdn, String message, Throwable throwable) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).info(message, throwable);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus error(String fqdn, String message) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).error(message);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus error(String fqdn, String message, Throwable throwable) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).error(message, throwable);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus fatal(String fqdn, String message) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).fatal(message);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}

	@Override
	public LogStatus fatal(String fqdn, String message, Throwable throwable) {
		Logger logger = Logger.getLogger(fqdn);
		if (logger != null){
			Logger.getLogger(fqdn).fatal(message, throwable);
			return LogStatus.SUCCESS;
		}
		else{
			return LogStatus.FAIL;
		}
	}
	
	
}
