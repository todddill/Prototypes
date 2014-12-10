package com.tetranetic.java.business;

import com.tetranetic.java.communication.DomainCommunicatorResponse;
import com.tetranetic.java.core.Communicator;
import com.tetranetic.java.core.Rules;
import com.tetranetic.java.core.RulesResults;
import com.tetranetic.java.domain.DomainRequest;
import com.tetranetic.java.loggerFacade.AppLogger;
import com.tetranetic.java.loggerFacade.LogType;

public class DomainController {
	
	private static final String FQDN = "com.tetranetic.java.business.DomainController";
	private AppLogger appLogger;
	
	public AppLogger getAppLogger()
	{
		return this.appLogger;
	}
	
	public void setAppLogger(AppLogger value)
	{
		this.appLogger = value;
	}

	public Object DomainOperation(Rules requestRules, Rules responseRules, Communicator communicator, DomainRequest source)
	{
		DomainCommunicatorResponse communicatorResponse = null;
		
		log(LogType.INFO, "DomainOperation called.");
		
		RulesResults requestRulesResults = runRules(requestRules, source, getRequestRules());
		
		if (requestRulesResults.getMessages().size() == 0)
		{
			communicatorResponse = (DomainCommunicatorResponse) communicator.send(requestRulesResults.getTranslatedObject());
			log(LogType.INFO, "Request sent.");
		}
		else{
			logErrorMessages(requestRulesResults);
			return null;
		}
		
		RulesResults responseRulesResults = runRules(responseRules, communicatorResponse, getResponseRules());
		
		if (responseRulesResults.getMessages().size() == 0)
			return responseRulesResults.getTranslatedObject();
		
		logErrorMessages(responseRulesResults);
		
		return null;
	}

	private RulesResults runRules(Rules rules, Object source, Object ruleDefinitions) {
		RulesResults requestRulesResults = (RulesResults) rules.run(ruleDefinitions, source);
		log(LogType.INFO, "Rules run.");
		return requestRulesResults;
	}

	private void logErrorMessages(RulesResults responseRulesResults) {
		for (String message : responseRulesResults.getMessages()) {
			log(LogType.ERROR, message);
		}
	}
	
	private void log(LogType logType, String message)
	{
		if (this.appLogger != null)
		{
			switch (logType)
			{
				case DEBUG:
					appLogger.debug(FQDN, message);
					break;
				case INFO:
					appLogger.info(FQDN, message);
					break;
				case ERROR:
					appLogger.error(FQDN, message);
					break;
				default:
					appLogger.fatal(FQDN, message);
			}
		}
	}
	
	private String getRequestRules()
	{
		return "xml or json rules here.";
	}
	
	private String getResponseRules()
	{
		return "xml or json rules here.";
	}
}
