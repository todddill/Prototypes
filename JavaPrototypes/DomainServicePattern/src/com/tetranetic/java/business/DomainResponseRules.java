package com.tetranetic.java.business;

import java.util.ArrayList;
import java.util.List;

import com.tetranetic.java.communication.DomainCommunicatorResponse;
import com.tetranetic.java.core.Rules;
import com.tetranetic.java.core.RulesResults;
import com.tetranetic.java.core.Translator;
import com.tetranetic.java.domain.DomainResponse;

public class DomainResponseRules implements Rules {
	
	private Translator translator;
	private RulesResults rulesResults = null;
	
	public DomainResponseRules(Translator translator)
	{
		this.translator = translator;
	}

	@Override
	public RulesResults run(Object rules, Object source) {
		Object translatedObject = translate((DomainResponse) source);
		this.rulesResults.setTranslatedObject(translatedObject);
		this.rulesResults.equals(runRules(translatedObject));
		return this.rulesResults;
	}
	
	private DomainCommunicatorResponse translate(DomainResponse source)
	{
		DomainCommunicatorResponse returnObject = null;
		
		if (this.translator != null)
			returnObject = (DomainCommunicatorResponse) this.translator.translate(source);
		
		return returnObject;
	}
	
	private List<String> runRules(Object source)
	{
		List<String> messages = new ArrayList<String>();
		return messages;
	}
}
