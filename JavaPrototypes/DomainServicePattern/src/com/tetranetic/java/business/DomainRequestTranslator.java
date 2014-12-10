package com.tetranetic.java.business;

import com.tetranetic.java.communication.DomainCommunicatorRequest;
import com.tetranetic.java.core.Translator;

public class DomainRequestTranslator implements Translator {

	@Override
	public DomainCommunicatorRequest translate(Object source) {
		// TODO Auto-generated method stub
		return new DomainCommunicatorRequest();
	}

}
