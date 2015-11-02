package com.marcelherd.uebung5.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.marcelherd.uebung5.Conversion;

import gdi.MakeItSimple.GDIException;;

public class Conversion1stTest {

	@Test
	public void vorabTest() throws Exception {
		assertEquals(123, Conversion.parseInteger("123"));
		assertEquals(3, Conversion.parseInteger("3"));
		assertEquals(0, Conversion.parseInteger("0"));
	}

	@Test(expected=GDIException.class)
	public void ungültigeEingabe() throws Exception {
		Conversion.parseInteger("x");
	}

}
