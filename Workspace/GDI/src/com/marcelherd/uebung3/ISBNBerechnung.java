package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

import gdi.MISException;

/**
 * Diese Klasse berechnet die Prüfziffer einer ISBN-13.
 * 
 * Testfälle:
 *  -1			  - ISBN zu kurz / klein (ungültig) -> MISException
 *  1231231231231 - ISBN zu lang / groß (ungültig) -> MISException
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 *
 */
public class ISBNBerechnung {

	public static void main(String[] args) {
		print("Bitte geben Sie die ISBN-13 (ohne Pruefziffer und Bindestriche) ein: ");
		String isbn = readLine();
		
		char[] chars = isbn.toCharArray();
		int[] zahlen = new int[12];
		for (int i = 0; i < chars.length; i++) {
			zahlen[i] = Integer.valueOf(chars[i] + "");
		}
		System.out.println(Arrays.toString(zahlen));
		
		int summe = 0;
		for (int i = 0; i < zahlen.length; i++) {
			if ((i+1) % 2 == 0) {
				summe += zahlen[i] * 3;
			} else {
				summe += zahlen[i];
			}
		}
		
		String summeString = summe + "";
		int letzteZahl = Integer.valueOf(summeString.charAt(summeString.length() - 1) + "");
		
		int pruefziffer = 0;
		if (summe != 10) {
			pruefziffer = 10 - letzteZahl;
		}
		println(pruefziffer);
	}

}
