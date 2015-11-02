package com.marcelherd.uebung5.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.marcelherd.uebung5.Palindrome;

public class Palindrome1stTest {

	@Test
	public void toLowerCaseTest() throws Exception {
		assertEquals("aba", Palindrome.toLowerCase("aba"));
		assertEquals("aba", Palindrome.toLowerCase("aBa"));
	}

	@Test
	public void removeSpacesTest() throws Exception {
		assertEquals("aa", Palindrome.removeSpaces("a a"));
	}

	@Test
	public void einfachesPalindrom() throws Exception {
		assertTrue(Palindrome.isPalindrome("aba"));
		assertTrue(Palindrome.isPalindrome("abba"));
	}

	@Test
	public void schwierigesPalindromMitLeerzeichenUndGrossbuchstaben() throws Exception {
		assertTrue(Palindrome.isPalindrome("Regal mit Sirup pur ist im Lager"));
	}

}
