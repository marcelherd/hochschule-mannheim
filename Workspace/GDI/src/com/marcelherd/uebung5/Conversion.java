package com.marcelherd.uebung5;

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
		println(parseInteger(number));
	}
	
	public static int parseInteger(String number) {
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
		boolean smaller = false;
		/*
		 * In dieser If-Abfrage wird überprüft, ob die eingegebene Zahl in einer
		 * Integer Variable gespeichert werden kann
		 */
		if (number.length() >= max.length()) {
			if (number.length() > max.length()) {
				valid = false;
			}

			for (int i = 0; i < number.length() - 1 && valid && !smaller; i++) {
				if (number.charAt(i) - '0' > max.charAt(i) - '0') {
					valid = false;
				} else if (number.charAt(i) - '0' < max.charAt(i) - '0') {
					smaller = true;
				}
			}

			if (number.charAt(number.length() - 1) - '0' > max.charAt(max.length() - 1) - '0' && !smaller) {
				if (sign == 1) {
					valid = false;
				} else if (number.charAt(number.length() - 1) != '8') {
					valid = false;
				}
			}
		}

		if (!valid) {
			if (sign == 1) {
				throw new GDIException("Die eingegebene Zahl ist zu groß! Maximal " + Integer.MAX_VALUE);
			} else {
				throw new GDIException("Die eingegebene Zahl ist zu klein! Mindestens " + Integer.MIN_VALUE);
			}
		}

		for (int i = number.length() - 1; i >= 0 && valid; i--) {
			if (number.charAt(i) < '0' || number.charAt(i) > '9') {
				throw new GDIException("Es muss eine Zahl eingegeben werden!");
			}

			sum += (number.charAt(i) - '0') * power;
			power *= 10;
		}

		if (sign == 1) {
			return (sum * sign);
		} else {
			return ((sum * sign) - 1);
		}
	}
}
