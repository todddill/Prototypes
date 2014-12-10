package com.tetranetic.java.business;

import java.util.ArrayList;
import java.util.List;

import com.tetranetic.java.communication.DomainCommunicatorRequest;
import com.tetranetic.java.core.Rules;
import com.tetranetic.java.core.RulesResults;
import com.tetranetic.java.core.Translator;
import com.tetranetic.java.domain.DomainRequest;

public class DomainRequestRules implements Rules {
	
	private Translator translator;
	private RulesResults rulesResults = null;
	
	public DomainRequestRules(Translator translator)
	{
		this.translator = translator;
	}

	@Override
	public RulesResults run(Object rules, Object source) {
		Object translatedObject = translate((DomainRequest) source);
		this.rulesResults.setTranslatedObject(translatedObject);
		this.rulesResults.equals(runRules(translatedObject));
		return this.rulesResults;
	}
	
	private DomainCommunicatorRequest translate(DomainRequest source)
	{
		DomainCommunicatorRequest returnObject = null;
		
		if (this.translator != null)
			returnObject = (DomainCommunicatorRequest) this.translator.translate(source);
		
		return returnObject;
	}
	
	private List<String> runRules(Object source)
	{
		List<String> messages = new ArrayList<String>();
		return messages;
	}
}
