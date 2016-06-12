package com.marcelherd.uebung4.quicksort;

import static gdi.MakeItSimple.*;

public class Aufgabe3 {

	private static final int TEST_CASE_SMALL = 1024;
	private static final int TEST_CASE_MEDIUM = 2048;
	private static final int TEST_CASE_LARGE = 4096;

	public static void main(String[] args) {
		println("------------------------------------------------");
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

		println("\n------------------------------------------------");
		println("Insertion sort variant");
		println("------------------------------------------------");

		trivial = new int[] { 44, 6, 55, 30, 94, 18 }; // example from slides
		println("Example array (unsorted): " + arrayToString(trivial));
		insertionSortVariant(trivial);
		println("Example array (sorted): " + arrayToString(trivial)); // just making sure it actually works
		println();
		
		small = generateRandomArray(TEST_CASE_SMALL);
		println("Sorting array of length " + TEST_CASE_SMALL + ":");
		insertionSortVariant(small);
		for(int i = 0; i<small.length-1; i++){
			if(small[i]>small[i+1]){
				System.err.println("FEHLER BEI I: " + i);
			}
		}

		medium = generateRandomArray(TEST_CASE_MEDIUM);
		println("\nSorting array of length " + TEST_CASE_MEDIUM + ":");
		insertionSortVariant(medium);
		for(int i = 0; i<medium.length-1; i++){
			if(medium[i]>medium[i+1]){
				System.err.println("FEHLER BEI I: " + i);
			}
		}
		large = generateRandomArray(TEST_CASE_LARGE);
		println("\nSorting array of length " + TEST_CASE_LARGE + ":");
		insertionSortVariant(large);
	}

	public static void insertionSort(int[] array) {
		int permutations = 0;
		int keyComparisons = 0;
		arrayToString(array);
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

	public static void insertionSortVariant(int[] array) {
		int permutations = 0;
		int keyComparisons = 0;
		for (int i = 1; i < array.length; i++) {
			int toBeInserted = array[i]; // remember the element that is to be inserted
			
			int insertIndex = -1;
			boolean indexFound = false;
			// tests if toBeInserted have the insertIndex 0, 1 or i.
			if (array[0] >= toBeInserted) { 
				keyComparisons++;
				insertIndex = 0;
				indexFound = true;
			} else if (array[i - 1] <= toBeInserted) {
				keyComparisons += 2; // 2 Comparisons were executed yet
									 // (else-if)
				insertIndex = i;
				indexFound = true;
			}else if(array[1] > toBeInserted){
				keyComparisons+= 3; // 3 Comparisons were executed yet
									// (else-if)
				insertIndex = 1;
				indexFound = true;
			}else {
				keyComparisons += 3; // 3 Comparisons were executed yet
									 // (else-if)
			}
			
			
			int u = 1;
			int o = i - 2;
			while (!indexFound && ((o - u) >= 0)) {
				int currentIndex = (o + u) / 2;
				if (toBeInserted > array[currentIndex]) {
					keyComparisons++;
					if (toBeInserted > array[currentIndex + 1]) {
						keyComparisons++;
						u = currentIndex + 1;
					} else {
						indexFound = true;
						insertIndex = currentIndex + 1;
					}
				} else if (toBeInserted < array[currentIndex]) {
					keyComparisons += 2; // 2 Comparisons were executed yet
										 // (else-if)
					if (toBeInserted < array[currentIndex - 1]) {
						keyComparisons++;
						o = currentIndex - 1;
					} else {
						indexFound = true;
						insertIndex = currentIndex;
					}
				} else {
					keyComparisons += 3; // 3 Comparisons were executed yet
										 // (else-if)
					indexFound = true;
					insertIndex = currentIndex + 1;
				}
			}

			for (int k = i; k > insertIndex; k--) {
				array[k] = array[k - 1];	
				permutations++;
			}

			if (array[insertIndex] != toBeInserted) {
				array[insertIndex] = toBeInserted; // permutation
				permutations++;
			}

			
		}
		println("Number of permutations: " + permutations);
		println("Number of key comparisons: " + keyComparisons);
	}

	/**
	 * Creates an array filled with random values between 1 and 4096
	 * 
	 * @param length
	 *            Array length
	 * @return int[] array
	 */
	protected static int[] generateRandomArray(int length) {
		final int MAX_VALUE = 4096;

		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			array[i] = (int) Math.floor(Math.random() * MAX_VALUE);
		}

		return array;
	}

	public static String arrayToString(int[] array) {
		String retval = "[";

		for (int i = 0; i < array.length; i++) {
			String delimiter = (i == array.length - 1 ? "" : ", "); // Omit trailing comma
			retval += array[i] + delimiter;
		}

		retval += "]";
		return retval;
	}

}
