package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse berechnet die Prüfziffer einer ISBN-13.
 * 
 * Testfälle
 * ------------------------
 * 
 * Input				Expected
 *  0					Fehler
 *  -1					Fehler
 *  abcdefg				Fehler
 *  978-0-306-40615-7	Fehler
 *  978-0-306-40615		Fehler
 *  978abc640615		Fehler
 *  -978030640615		Fehler
 *  -97803064061		Fehler
 *  978030640615		Gültig
 *  
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 *
 */
public class ISBNBerechnung {

	public static void main(String[] args) {
		boolean isbnValid;
		String isbn;
		println("Bitte geben Sie eine ISBN ohne Bindestriche und Buchstaben ein!");
		
		do {
			isbnValid = true;
			
			isbn = readLine();
			
			//TODO: Validierung mit Prädikaten
			if (isbn.length() != 12) {
				println("Die ISBN muss 12 Ziffern lang sein! Bitte erneut eingeben!");
				isbnValid = false;
			}
			
			for (int i = 0; i < isbn.length(); i++) {
				if (isbn.charAt(i) < '0' || isbn.charAt(i) > '9') {
					println("Die ISBN darf nur aus Zahlen bestehen! Bitte erneut eingeben!");
					isbnValid = false;
					break;
				}
			}
		} while (!isbnValid);

		int sum = 0;
		
		for (int i = 0; i < isbn.length(); i++) {
			if ((i + 1) % 2 == 0) {
				sum += charToInt(isbn.charAt(i)) * 3;
			} else {
				sum += charToInt(isbn.charAt(i));
			}
		}
		
		int pruefziffer = 0;
		
		// Wenn die letzte Zahl der Summe 0 ist, so bleibt die Prüfziffer 0
		if (sum % 10 != 0) {
			pruefziffer = 10 - sum % 10;
		}
		
		print("Pruefziffer:" + pruefziffer);
	}
	
	/**
	 * Diese Funktion konvertiert einen gegebenen char zu int.
	 * 
	 * @param c char der konvertiert werden soll
	 * @return int
	 */
	private static int charToInt(char c) {
		return c - '0';
	}

}
