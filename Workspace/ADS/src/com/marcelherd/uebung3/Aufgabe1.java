package com.marcelherd.uebung3;

import static gdi.MakeItSimple.*;

public class Aufgabe1 {
	
	public static final int NO_KEY = -1;

	public static void main(String[] args) {
		int[] testArray = { 1, 3, 5, 2, 8, 6, 0, 7, 4, 9, 6, 1, 3, 9, 2, 5, 8, 4, 7, 0 };
		println("Test Array: " + arrayToString(testArray));
		print("Please enter a key: ");
		int key = readInt();
		
		println("a) linearSearchUntilLast(int[] array, int key)");
		println("Result: " + linearSearchUntilLast(testArray, key));
		
		println("b) linearSearchUntilFirst(int[] array, int key)");
		println("Result: " + linearSearchUntilFirst(testArray, key));
		
		println("c) binarySearchRecursively(int[] array, int key, int u, int o)");
		println("Result: " + binarySearchRecursively(testArray, key, 1, testArray.length));
		
		println("d) binarySearchIteratively(int[] array, int key)");
		println("Result: " + binarySearchIteratively(testArray, key));
	}

	// a)
	public static int linearSearchUntilLast(int[] array, int key) {
		int index = NO_KEY; // default: no element found
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				index = i;
			}
		}
		
		return index;
	}

	// b)
	public static int linearSearchUntilFirst(int[] array, int key) {
		int index = NO_KEY; // default: no element found
		boolean found = false;
		
		for (int i = 0; i < array.length && !found; i++) {
			if (array[i] == key) {
				index = i;
				found = true;
			}
		}
		
		return index;
	}

	// c)
	public static int binarySearchRecursively(int[] array, int key, int u, int o) {
		int currentIndex = (u + o) / 2;
		
		if (o - u <= 0) {
			return NO_KEY;
		} else if (key == array[currentIndex]) { // found the key
			return currentIndex;
		} else if (key > array[currentIndex]) {
			u = currentIndex + 1; // resume search in upper half
		} else {
			o = currentIndex - 1; // resume search in lower half
		}

		return binarySearchRecursively(array, key, u, o);
	}

	// d)
	public static int binarySearchIteratively(int[] array, int key) {
		int u = 1;
		int o = array.length - 1;
		int currentIndex = (u + o) / 2;

		while (o - u >= 0) {
			currentIndex = (u + o) / 2;
			
			if (key == array[currentIndex]) { // found the key
				return currentIndex;
			} else if (key > array[currentIndex]) {
				u = currentIndex + 1; // resume search in upper half
			} else {
				o = currentIndex - 1; // resume search in lower half
			}
		}
		
		return NO_KEY;
	}
	
	private static String arrayToString(int[] array) {
		String retval = "[";
		
		for (int i = 0; i < array.length; i++) {
			String delimiter = (i == array.length - 1 ? "" : ", "); // Kein Komma nach dem letzten Element
			retval += array[i] + delimiter;
		}
		
		retval += "]";
		return retval;
	}
	
}
