package com.tetranetic.java.core;

import java.util.ArrayList;
import java.util.List;

public class RulesResults {
	
	private List<String> messages = new ArrayList<String>();
	private Object translatedObject = new Object();
	
	public Object getTranslatedObject() {
		return translatedObject;
	}
	public void setTranslatedObject(Object translatedObject) {
		this.translatedObject = translatedObject;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
