package com.marcelherd.uebung6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.marcelherd.uebung6.StringExtensions;

public class StringExtensions1stTest {

	@Test
	public void testStrToUpper() {
		assertEquals("GDI IST EINE ABKÜRZUNG FÜR GRUNDLAGEN DER INFORMATIK.", StringExtensions.toUpper("GDI ist eine Abkürzung für Grundlagen der Informatik."));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrExplode() {
		assertArrayEquals(new String[]{"Banane","Apfel","Birne"}, StringExtensions.split("Banane,Apfel,Birne", ','));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrScan() {
		assertEquals(4, StringExtensions.scan("abcdefghi", "efg"));
	}
}