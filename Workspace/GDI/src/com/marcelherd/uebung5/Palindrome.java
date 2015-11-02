package com.marcelherd.uebung5;

import static gdi.MakeItSimple.*;

public class Palindrome {

	public static void main(String[] args) {
		println("Bitte geben Sie den Text ein, der auf Palindrom-Eigenschaft ueberprueft werden soll: ");
		String text = readLine();
		
		if (isPalindrome(text)) {
			println("Das ist ein Palindrom!");
		} else {
			println("Das ist kein Palindrom :(");
		}
	}

	private static boolean isPalindrome(String text) {
		text = removeSpaces(text);
		text = toLowerCase(text);

		String palindrome = "";

		for (int i = text.length() - 1; i >= 0; i--) {
			palindrome += text.charAt(i);
		}

		return text.equals(palindrome);
	}

	private static String toLowerCase(String text) {
		String retval = "";

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				c = (char) (c - 'A' + 'a');
			}

			retval += c;
		}

		return retval;
	}

	private static String removeSpaces(String text) {
		String retval = "";

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (c != ' ') {
				retval += c;
			}
		}

		return retval;
	}

}