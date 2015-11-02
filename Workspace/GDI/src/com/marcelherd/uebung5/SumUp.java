package com.marcelherd.uebung5;

import static gdi.MakeItSimple.*;

public class SumUp {

	public static void main(String[] args) {
		println("Bitte geben Sie ein wie viele Zahlen aufsummiert werden sollen: ");

		int length = readInt();
		int[] numbers = readNumbers(length);

		println("Summe der eingegebenen Zahlen: " + sumUpNumbers(numbers));
	}

	/**
	 * Diese Funktion liest eine gegebene Anzahl von Integern ein.
	 * 
	 * @param length Anzahl der einzulesenden Integer.
	 * @return int[] Eingelesene Integer
	 */
	private static int[] readNumbers(int length) {
		if (length >= 0) {
			int[] numbers = new int[length];
			
			for (int i = 0; i < length; i++) {
				print("Bitte geben Sie Zahl " + (i + 1) + " ein: ");
				numbers[i] = readInt();
			}
			
			return numbers;
		} else {
			println("Findest du das wirklich sinnvoll?");
			return new int[] {};
		}
	}

	/**
	 * Diese Funktion berechnet die Summe der übergebenen Integer.
	 * 
	 * @param numbers int[] Integer die aufsummiert werden sollen.
	 * @return int Summe
	 */
	public static int sumUpNumbers(int[] numbers) {
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}

		return sum;
	}

}