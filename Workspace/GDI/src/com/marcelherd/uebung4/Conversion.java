package com.marcelherd.uebung4;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse konvertiert einen String in einen Integer.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public class Conversion {

	public static void main(String[] args) {
		println("Bitte geben Sie eine ganze Zahl ein: ");
		String number = readLine();

		int power = 1;
		int sign = 1;
		int sum = 0;
		boolean valid = true;

		if (number.charAt(0) == '-') {
			sign = -1;
			/*
			 * |MIN_VALUE| ist |MAX_VALUE| + 1. Da die Validitätsprüfung
			 * Vorzeichenunbehaftet stattfindet muss also 1 von der Summe
			 * abgezogen werden, um im Integer Bereich zu bleiben.
			 */
			sum = -1;
			number = number.substring(1);
		} else {
			sign = 1;
		}

		String max = Integer.MAX_VALUE + "";

		/*
		 * In dieser If-Abfrage wird überprüft, ob die eingegebene Zahl in einer
		 * Integer Variable gespeichert werden kann
		 */
		if (number.length() >= max.length()) {
			if (number.length() > max.length()) {
				valid = false;
			}

			for (int i = 0; i < number.length() - 1 && valid; i++) {
				if (number.charAt(i) - '0' > max.charAt(i) - '0') {
					valid = false;
				}
			}

			if (number.charAt(number.length() - 1) - '0' > max.charAt(max.length() - 1) - '0') {
				if (sign == 1) {
					valid = false;
				} else if (number.charAt(number.length() - 1) != '8') {
					valid = false;
				}
			}
		}

		if (!valid) {
			println("Fehler, eingegebene Zahl ist zu groß!");
		}

		for (int i = number.length() - 1; i >= 0 && valid; i--) {
			if (number.charAt(i) < '0' || number.charAt(i) > '9') {
				println("Fehler, eingegebener String ist keine gueltige Zahl!");
				valid = false;
			}

			sum += (number.charAt(i) - '0') * power;
			power *= 10;
		}

		if (valid) {
			if (sign == 1) {
				print(sum * sign);
			} else {
				print((sum * sign) - 1);
			}
		}
	}
}
