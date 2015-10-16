package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

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
public class Alternative {

		public static void main(String[] args) {
		boolean isbnCorrect;
		String isbn;
		println("Bitte geben Sie eine ISBN ohne Bindestriche und Buchstaben ein!");
		// do-while Schleife um zu prüfen ob die eingegebene Zahl das richtige
		// Format hat
		do {
			// isbn wird eingegeben und es wird davon ausgegangen, dass sie
			// korrekt ist.
			isbn = readLine();
			isbnCorrect = true;
			// Die Länge der ISBN wird geprüft. besitzt sie nicht genau die
			// Länge 12 (ISBN-13 besitzt 13 Zeichen. Ohne Prüfziffer 12), so
			// wird "isbnCorrect" auf false gesetzt und die do-while Schleife am
			// Ende wiederholt
			if (isbn.length() != 12) {
				println("ISBN ist zu lang/kurz! Bitte erneut eingeben!");
				isbnCorrect = false;
			}
			// Hier wird jedes Einzelne Zeichen auf seine Richtigkeit geprüft.
			// Ist eines keine Zahl, so wird "isbnCorrect" wieder auf false
			// gesetzt und die do-while Schleife wiederholt.
			for (int i = 0; i < isbn.length(); i++) {
				if (isbn.charAt(i) < '0' || isbn.charAt(i) > '9') {
					println("Das " + (i + 1) + ". Zeichen der ISBN ist keine Zahl! Bitte erneut eingeben!");
					isbnCorrect = false;
				}
			}

			// Abfrage ob die ISBN als korrekt eingestuft wurde("isbnCorrect").
			// Falls ja,
			// bricht die Schleife ab. Falls nein, so wird die Eingabe und
			// Prüfung wiederholt.
		} while (!isbnCorrect);

		// Eine temporäre Variable für die Summe aller Zahlen in der ISBN wird
		// initialisiert.
		int sum = 0;
		// Die For-Schleife addiert die einzelnen Zahlen der ISBN zu "sum"
		// hinzu....
		for (int i = 0; i < isbn.length(); i++) {
			// ...ist die Zahl gerade, so wird der dreifache Wert addiert...
			if ((i + 1) % 2 == 0) {
				sum += (isbn.charAt(i) - '0') * 3;
			} else {
				// .. ist sie hingegen ungerade, wird lediglich der einfache
				// Wert addiert.
				sum += (isbn.charAt(i) - '0');
			}
		}
		// Zum Schluss wird geprüft ob die Summe aller Ziffern nicht 10 ist...
		int pruefziffer = 0;
		if (sum % 10 != 0) {
			// ...ist dies der Fall, so wird "sum % 10"(=Letzte Zahl der Summe)
			// von 10 Subtrahiert und dies ist die Prüfziffer.
			pruefziffer = 10 - sum % 10;
		}
		// ...ist dies hingegen nicht der Fall, so bleibt die Prüfziffer 0

		// Zuletzt wird die Prüfziffer ausgegeben
		print(pruefziffer);
	}

}
