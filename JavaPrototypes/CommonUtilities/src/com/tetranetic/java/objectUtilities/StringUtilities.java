package com.tetranetic.java.objectUtilities;

public class StringUtilities {
	
	public static boolean isNullOrEmpty(String string)
	{
		return string == null || string.trim().length() == 0;
	}
}
