package com.tetranetic.java.objectUtilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tetranetic.java.objectUtilities.StringUtilities;

public class StringUtilitiesTest {
	
	private static final String EMPTY = "";
	private static final String NOTEMPTY = "string";
	private static final String SPACES = " ";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNullOrEmptyStringEmptyIsTrue() {
		boolean expected = true;
		boolean actual = StringUtilities.isNullOrEmpty(EMPTY);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsNullOrEmptyStringNotEmptyIsFalse() {
		boolean expected = false;
		boolean actual = StringUtilities.isNullOrEmpty(NOTEMPTY);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testIsNullOrEmptyStringSpacesIsTrue() {
		boolean expected = true;
		boolean actual = StringUtilities.isNullOrEmpty(SPACES);
		
		assertEquals(expected, actual);
	}
}
