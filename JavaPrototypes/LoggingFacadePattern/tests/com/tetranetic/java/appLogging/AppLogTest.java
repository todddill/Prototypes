package com.tetranetic.java.appLogging;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tetranetic.java.appLogging.AppLog;
import com.tetranetic.java.appLogging.AppLoggerMock;
import com.tetranetic.java.loggerFacade.LogStatus;
import com.tetranetic.java.loggerFacade.LogType;

public class AppLogTest {
	
	private static final String FQDN = "com.tetranetic.java.applogging.AppLogTest";
	private static final String MESSAGE = "Log test.";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogStringStringAppLoggerLogType() {
		LogStatus expected = LogStatus.SUCCESS;
		
		AppLog appLog = new AppLog();
		LogStatus actual = appLog.log(FQDN, MESSAGE, new AppLoggerMock(), LogType.DEBUG);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testLogStringStringAppLoggerLogTypeThrowable() {
		LogStatus expected = LogStatus.SUCCESS;
		
		AppLog appLog = new AppLog();
		LogStatus actual = appLog.log(FQDN, MESSAGE, new AppLoggerMock(), LogType.DEBUG, new NullPointerException());
		
		assertEquals(expected, actual);
	}

}
