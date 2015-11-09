package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

public class Aufgabe3 {

	private static final int TEST_CASE_SMALL = 1024;
	private static final int TEST_CASE_MEDIUM = 2048;
	private static final int TEST_CASE_LARGE = 4096;
	
	public static void main(String[] args) {
		println("Default insertion sort (as discussed in lecture)");
		println("------------------------------------------------");
		
		int[] trivial = new int[] { 44, 6, 55, 30, 94, 18 }; // example from slides
		println("Example array (unsorted): " + arrayToString(trivial));
		insertionSort(trivial);
		println("Example array (sorted): " + arrayToString(trivial)); // just making sure it actually works
		println();
		
		int[] small = generateRandomArray(TEST_CASE_SMALL);
		println("Sorting array of length " + TEST_CASE_SMALL + ":");
		insertionSort(small);
		
		int[] medium = generateRandomArray(TEST_CASE_MEDIUM);
		println("\nSorting array of length " + TEST_CASE_MEDIUM + ":");
		insertionSort(medium);
		
		int[] large = generateRandomArray(TEST_CASE_LARGE);
		println("\nSorting array of length " + TEST_CASE_LARGE + ":");
		insertionSort(large);
	}
	
	public static void insertionSort(int[] array) {
		int permutations = 0;
		int keyComparisons = 0;
		
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int toBeInserted = array[i]; // remember the element that is to be inserted
			
			while (j > 0 && array[j - 1] > toBeInserted) { // key comparison
				keyComparisons++;
				array[j] = array[j - 1]; // shifting elements 'to the right' -> permutation
				permutations++;
				j -= 1;
			}
			
			keyComparisons++; // Don't forget the break condition comparison
			array[j] = toBeInserted; // permutation
			permutations++;
		}
		
		println("Number of permutations: " + permutations);
		println("Number of key comparisons: " + keyComparisons);
	}
	
	/**
	 * Creates an array with random values between 1 and 4096
	 * 
	 * @param length Array length
	 * @return int[] array
	 */
	private static int[] generateRandomArray(int length) {
		final int MAX_VALUE = 4096;
		
		int[] array = new int[length];
		
		for (int i = 0; i < length; i++) {
			array[i] = (int) Math.floor(Math.random() * MAX_VALUE);
		}
		
		return array;
	}
	
	private static String arrayToString(int[] array) {
		String retval = "[";
		
		for (int i = 0; i < array.length; i++) {
			String delimiter = (i == array.length - 1 ? "" : ", "); // Omit trailing comma
			retval += array[i] + delimiter;
		}
		
		retval += "]";
		return retval;
	}

}
