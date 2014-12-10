package com.tetranetic.java.appLogging;

import com.tetranetic.java.loggerFacade.AppLogger;
import com.tetranetic.java.loggerFacade.LogStatus;
import com.tetranetic.java.objectUtilities.StringUtilities;

public class AppLoggerMock implements AppLogger {

	@Override
	public LogStatus debug(String fqdn, String message) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus debug(String fqdn, String message, Throwable throwable) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus info(String fqdn, String message) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus info(String fqdn, String message, Throwable throwable) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus error(String fqdn, String message) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus error(String fqdn, String message, Throwable throwable) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus fatal(String fqdn, String message) {
		return isFqdnNullOrEmpty(fqdn);
	}

	@Override
	public LogStatus fatal(String fqdn, String message, Throwable throwable) {
		return isFqdnNullOrEmpty(fqdn);
	}
	
	private LogStatus isFqdnNullOrEmpty(String fqdn)
	{
		if (StringUtilities.isNullOrEmpty(fqdn)) return LogStatus.FAIL;
		return LogStatus.SUCCESS;
	}

}
