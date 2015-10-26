package com.marcelherd.uebung4;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse berechnet die Prüfziffer einer ISBN-13.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public class AufgabeEins {

	public static void main(String[] args) {
		println("Bitte geben Sie eine ganze Zahl ein: ");
		int number = readInt();

		decomposeNumber(number);
	}

	/**
	 * Diese Funktion zerlegt eine Zahl in ihre einzelnen Ziffern. Die Ziffern
	 * werden im Format (+/-)z, z, z, ... ausgegeben.
	 * 
	 * @param number
	 *            Zahl, die zerlegt werden soll
	 */
	private static void decomposeNumber(int number) {
		if (number < 0) {
			print('-');
			print(',');
			print(' ');
			number *= -1;
		} else {
			print('+');
			print(',');
			print(' ');
		}

		int initialLength = getLength(number);

		for (int i = 0; i < initialLength; i++) {
			int length = getLength(number);

			if (length == 1) {
				print(number);
				return;
			}

			int power = 1;
			for (int j = 1; j < length; j++) {
				power *= 10;
			}

			print(number / power);
			print(',');
			print(' ');
			number -= (number / power) * power;
		}
	}

	/**
	 * Diese Funktion berechnet die Anzahl der Ziffern in einer Zahl (= Länge
	 * der Zahl)
	 * 
	 * @param number
	 *            Zahl, deren Länge berechnet werden soll
	 * @return Länge der Zahl
	 */
	public static int getLength(int number) {
		int length = 1;
		int power = 10;

		while (power < number) {
			power *= 10;
			length++;
		}

		return length;
	}

}
