package com.tetranetic.java.loggerFacade;

public interface AppLogger {
	
	LogStatus debug(String fqdn, String message);
	LogStatus debug(String fqdn, String message, Throwable throwable);
	
	LogStatus info(String fqdn, String message);
	LogStatus info(String fqdn, String message, Throwable throwable);
	
	LogStatus error(String fqdn, String message);
	LogStatus error(String fqdn, String message, Throwable throwable);
	
	LogStatus fatal(String fqdn, String message);
	LogStatus fatal(String fqdn, String message, Throwable throwable);
}
