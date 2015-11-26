package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

public class Aufgabe4 {
	
	public static void main(String[] args) {
		println("------------------------------------------------");
		println("Shaker sort");
		println("------------------------------------------------");
		
		int[] trivial = new int[] { 44, 55, 12, 42, 94, 18, 6, 67  }; // example from slides
		shakerSort(trivial);
	}
	
	public static void shakerSort(int[] array) {
		int permutations = 0;
		int keyComparisons = 0;
		int depth = 0;
		
		boolean mutation;
		boolean direction = true; // initial direction left to right
		
		do {
			mutation = false;
			
			if (direction) { // left to right
				for (int i = 0; i < array.length - 1; i++) {
					if (array[i] > array[i + 1]) { // key comparison
						// swap array[i] with array[i + 1] -> 1 permutation
						array[i] = array[i] ^ array[i + 1];
						array[i + 1] = array[i] ^ array[i + 1];
						array[i] = array[i] ^ array[i + 1];
						mutation = true; // something changed, we're not done yet
						permutations++;
					}
					
					keyComparisons++;
				}
			} else { // right to left
				for (int i = array.length - 2; i >= 0; i--) {
					if (array[i + 1] < array[i]) { // key comparison
						// swap array[i + 1] with array[i] -> 1 permutation
						array[i + 1] = array[i + 1] ^ array[i];
						array[i] = array[i + 1] ^ array[i];
						array[i + 1] = array[i + 1] ^ array[i];
						mutation = true; // something changed, we're not done yet
						permutations++;
					}
					
					keyComparisons++;
				}
			}
			
			direction = !direction; // invert direction
			depth++;
		} while (mutation);
	}
	
	/**
	 * Generates a string representation of an array as per the example on Blatt 3 Aufgabe 4.
	 * 
	 * @param array
	 * @param depth Iteration depth
	 * @return String representation of array
	 */
	private static String arrayToString(int[] array, int depth) {
		String retval = "F" + depth + " =\t";
		
		for (int i = 0; i < array.length; i++) {
			retval += + array[i] + "\t";
		}
		
		if (depth == 0) {
			retval += "(Ausgangsfolge)";
		} else {
			retval += "(nach dem " + depth + ". Durchlauf)";
		}
		
		return retval;
	}
	
	/**
	 * Generates a string representation of an array as per the example on Blatt 3 Aufgabe 4.
	 * Includes highlighting support for swapped indices.
	 * 
	 * @param array
	 * @param depth Iteration depth
	 * @param firstIndex Index of the first number that should be highlighted
	 * @param secondIndex Index of the second number that should be highlighted
	 * @return String representation of array
	 */
	public static String arrayToString(int[] array, int depth, int firstIndex, int secondIndex) {
		String retval = "F" + depth + " =\t";
		
		for (int i = 0; i < array.length; i++) {
			if (i == firstIndex || i == secondIndex) {
				retval += "*" + array[i] + "*" + "\t";
			} else {
				retval += + array[i] + "\t";
			}
		}
		
		retval += "(Vertauschung)";
		
		return retval;
	}

}
