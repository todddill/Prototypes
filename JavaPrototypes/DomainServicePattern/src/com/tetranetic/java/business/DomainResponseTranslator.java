package com.tetranetic.java.business;

import com.tetranetic.java.communication.DomainCommunicatorResponse;
import com.tetranetic.java.core.Translator;

public class DomainResponseTranslator implements Translator {

	@Override
	public DomainCommunicatorResponse translate(Object source) {
		// TODO Auto-generated method stub
		return new DomainCommunicatorResponse();
	}

}
