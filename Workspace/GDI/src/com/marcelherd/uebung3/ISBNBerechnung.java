package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

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
		print("Bitte geben Sie die ISBN-13 (ohne Pruefziffer) ein: ");
		int isbn = readInt();
	}

}
