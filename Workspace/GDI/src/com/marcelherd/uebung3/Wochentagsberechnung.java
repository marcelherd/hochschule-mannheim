package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

import gdi.MISException;

/**
 * Diese Klasse berechnet den Wochentag zu einem gegebenen Datum.
 * 
 * Algorithmus: https://de.wikipedia.org/wiki/Wochentagsberechnung
 * 
 * Testfälle
 * -----------------------------
 * 
 * Input				Expected
 *  01.01.1900			"Montag"
 *  29.02.1900			"Datumsangabe ungültig"
 *  31.12.1899			"Datumsangabe ungültig"			
 *  31.12.2019			"Dienstag"
 *  01.01.2020			"Datumsangabe ungültig"
 *  31.02.2015			"Datumsangabe ungültig"
 *  29.02.2015			"Datumsangabe ungültig"
 *  29.02.2012			"Mittwoch"
 *  29.2.2012			"Mittwoch"
 *  19.10.2015			"Montag"
 *  -21.01.1900			"Datumsangabe ungültig"
 *  a.a.a				"Datumsangabe ungültig"
 *  39.45.2015			"Datumsangabe ungültig"
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 *
 */
public class Wochentagsberechnung {

	public static void main(String[] args) {
		int[] monatsziffern = getMonatsziffern();
		String[] wochentage = getWochentage();
		
		int jahr;
		int monat;
		int tag;
		
		try {
			print("Bitte geben Sie das Kalenderjahr als Zahl ein: ");
			jahr = readInt();
			print("Bitte geben Sie den Kalendermonat als Zahl ein: ");
			monat = readInt();
			print("Bitte geben Sie den Tag (im Monat) als Zahl ein: ");
			tag = readInt();
			
			if (jahr < 1900 || jahr > 2019) {
				throw new MISException(); // MISException wird anstelle einer eigenen Exception mißbraucht
			}
			
			if (monat < 1 || monat > 12) {
				throw new MISException();
			}
			
			if (tag < 1 || tag > 31) {
				throw new MISException();
			}
			
			// Sonderfälle für variable Monatslängen
			if (
					(monat <= 7 && monat % 2 == 0 && tag == 31) ||
				    (monat == 2 && tag > 28 && jahr % 4 != 0) ||
				    (monat == 2 && tag > 29 && jahr % 4 == 0) ||
				    (monat > 7 && monat % 2 != 0 && tag == 31)
			) {
				throw new MISException();
			}
			
			// Sonderfall: 1900 ist kein Schaltjahr. Unsaubere Lösung aber funktional.
			if (monat == 2 && tag > 28 && jahr == 1900) {
				throw new MISException();
			}
			
			int jahrhundert = jahr / 100;
			int jahreszahl = jahr - (jahrhundert * 100);
			
			int tagesziffer = tag % 7;
			int jahresziffer = (jahreszahl + (jahreszahl / 4)) % 7;
			int jahrhundertziffer = (3 - (jahrhundert % 4)) * 2;
			
			int korrekturziffer = 0;
			if ((jahreszahl % 4 == 0) && (monat <= 2) && (jahr != 1900)) {
				korrekturziffer = 6; // vordefiniert
			}
			
			int wochentagIndex = (tagesziffer + monatsziffern[monat - 1] + jahresziffer + jahrhundertziffer + korrekturziffer) % 7;
			String wochentag = wochentage[wochentagIndex];
			println("Wochentag: " + wochentag);
		} catch (MISException e) {
			println("Datumsangabe ungültig");
		}
	}

	/**
	 * Diese Funktion liefert die Monatsziffern für die Wochentagsberechnung.
	 * Diese Ziffern sind vordefiniert.
	 * 
	 * @return int[] Monatsziffern
	 */
	private static int[] getMonatsziffern() {
		return new int[] { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
	}
	
	/**
	 * Diese Funktion liefert die Wochentage beginnend mit Sonntag.
	 * 
	 * @return String[] Wochentage
	 */
	private static String[] getWochentage() {
		return new String[] { "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag" };
	}

}
