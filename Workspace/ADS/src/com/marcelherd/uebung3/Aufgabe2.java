package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

public class Aufgabe2 {

	public static final int NO_KEY = -1;
	private static final int TEST_CASE_SMALL = 1024;
	private static final int TEST_CASE_MEDIUM = 2048;
	private static final int TEST_CASE_LARGE = 4096;
	
	public static void main(String[] args) {
		
		runSuccessfullRuns();
		runUnsuccessfullRuns(Integer.MIN_VALUE);
		
	}

	// a)
	public static int linearSearchUntilLast(int[] array, int key) {
		int keyComparisons = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				/*
				 * here the index would be saved into a variable, but unused
				 * cause it's unnecessary for keyComparison - counting
				 */
			}
			keyComparisons++; // Count keyComparisons
		}

		return keyComparisons;
	}

	// b)
	public static int linearSearchUntilFirst(int[] array, int key) {
		int keyComparisons = 0;
		boolean found = false;

		for (int i = 0; i < array.length && !found; i++) {
			if (array[i] == key) {
				/*
				 * index saving has been removed because it's unnecessary for
				 * keyComparisons - counting
				 */
				found = true;
			}
			keyComparisons++;
		}

		return keyComparisons;
	}

	// c)
	public static int binarySearchRecursively(int[] array, int key, int u, int o) {
		int currentIndex = (u + o) / 2;
		int keyComparisons = 0;

		if (o - u <= 0) {
			return NO_KEY;
		} else if (key == array[currentIndex]) { // found the key
			keyComparisons++;
			return keyComparisons;
		} else if (key > array[currentIndex]) {
			keyComparisons += 2; // 2 Comparisons were executed yet (else-if)
			u = currentIndex + 1; // resume search in upper half
		} else {
			keyComparisons += 2; // 2 Comparisons were executed yet (else-if)
			o = currentIndex - 1; // resume search in lower half
		}

		return keyComparisons + binarySearchRecursively(array, key, u, o);
	}

	// d)
	public static int binarySearchIteratively(int[] array, int key) {
		int u = 1;
		int o = array.length - 1;
		int currentIndex = (u + o) / 2;
		int keyComparisons = 0;

		while (o - u >= 0) {
			currentIndex = (u + o) / 2;

			if (key == array[currentIndex]) { // found the key
				keyComparisons++;
				return keyComparisons;
			} else if (key > array[currentIndex]) {
				keyComparisons += 2; // 2 Comparisons were executed yet
										// (else-if)
				u = currentIndex + 1; // resume search in upper half
			} else {
				keyComparisons += 2; // 2 Comparisons were executed yet
									 // (else-if)
				o = currentIndex - 1; // resume search in lower half
			}
		}

		return keyComparisons;
	}

	public static void runUnsuccessfullRuns(int key){
		int keyComparisons = 0;
		println("\n------------------------------------------------");
		println("Run Successfull Runs");
		println("------------------------------------------------");
		
		println("\n------------------------------------------------");
		println("linearSearchUntilLast");
		println("------------------------------------------------");
		println("Browsing array of length " + TEST_CASE_SMALL + ":");
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			keyComparisons += linearSearchUntilLast(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			keyComparisons += linearSearchUntilLast(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			keyComparisons += linearSearchUntilLast(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\n------------------------------------------------");
		println("linearSearchUntilFirst");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			keyComparisons += linearSearchUntilFirst(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			keyComparisons += linearSearchUntilFirst(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			keyComparisons += linearSearchUntilFirst(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\n------------------------------------------------");
		println("binarySearchRecursively");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			keyComparisons += binarySearchRecursively(small, key, 0, small.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			keyComparisons += binarySearchRecursively(medium, key, 0, medium.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			keyComparisons += binarySearchRecursively(large, key, 0, large.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		
		println("\n------------------------------------------------");
		println("binarySearchIteratively");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			keyComparisons += binarySearchIteratively(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			keyComparisons += binarySearchIteratively(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			keyComparisons += binarySearchIteratively(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
	}


	
	public static void runSuccessfullRuns(){
		int keyComparisons = 0;
		println("\n------------------------------------------------");
		println("Run Unsuccessfull Runs");
		println("------------------------------------------------");
		
		println("\n------------------------------------------------");
		println("linearSearchUntilLast");
		println("------------------------------------------------");
		println("Browsing array of length " + TEST_CASE_SMALL + ":");
		int key = -1;
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			key = small[(int) Math.floor(Math.random()*small.length-1)+1];
			keyComparisons += linearSearchUntilLast(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			key = medium[(int) Math.floor(Math.random()*medium.length-1)+1];
			keyComparisons += linearSearchUntilLast(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			key = large[(int) Math.floor(Math.random()*large.length-1)+1];
			keyComparisons += linearSearchUntilLast(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\n------------------------------------------------");
		println("linearSearchUntilFirst");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		key = -1;
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			key = small[(int) Math.floor(Math.random()*small.length-1)+1];
			keyComparisons += linearSearchUntilFirst(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			key = medium[(int) Math.floor(Math.random()*medium.length-1)+1];
			keyComparisons += linearSearchUntilFirst(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			key = large[(int) Math.floor(Math.random()*large.length-1)+1];
			keyComparisons += linearSearchUntilFirst(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\n------------------------------------------------");
		println("binarySearchRecursively");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		key = -1;
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			key = small[(int) Math.floor(Math.random()*small.length-1)+1];
			keyComparisons += binarySearchRecursively(small, key, 0, small.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			key = medium[(int) Math.floor(Math.random()*medium.length-1)+1];
			keyComparisons += binarySearchRecursively(medium, key, 0, medium.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			key = large[(int) Math.floor(Math.random()*large.length-1)+1];
			keyComparisons += binarySearchRecursively(large, key, 0, large.length-1);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		
		println("\n------------------------------------------------");
		println("binarySearchIteratively");
		println("------------------------------------------------");
		println("\nBrowsing array of length " + TEST_CASE_SMALL + ":");
		key = -1;
		for(int i = 0; i<100; i++){
			int[] small = Aufgabe3.generateRandomArray(TEST_CASE_SMALL);
			key = small[(int) Math.floor(Math.random()*small.length-1)+1];
			keyComparisons += binarySearchIteratively(small, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_SMALL +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_MEDIUM + ":");
		for(int i = 0; i<100; i++){
			int[] medium = Aufgabe3.generateRandomArray(TEST_CASE_MEDIUM);
			key = medium[(int) Math.floor(Math.random()*medium.length-1)+1];
			keyComparisons += binarySearchIteratively(medium, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_MEDIUM +  ": " + keyComparisons/100);
		keyComparisons = 0;
		
		println("\nBrowsing array of length " + TEST_CASE_LARGE + ":");
		for(int i = 0; i<100; i++){
			int[] large = Aufgabe3.generateRandomArray(TEST_CASE_LARGE);
			key = large[(int) Math.floor(Math.random()*large.length-1)+1];
			keyComparisons += binarySearchIteratively(large, key);
		}
		println("KeyComparisons for an array of length " + TEST_CASE_LARGE +  ": " + keyComparisons/100);
		keyComparisons = 0;
	}


}
