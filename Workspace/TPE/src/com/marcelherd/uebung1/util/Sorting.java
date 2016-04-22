package com.marcelherd.uebung1.util;

public class Sorting {
	/**
	 * Sorts the given array using bubble sort algorithm
	 * 
	 * @param a - array that is to be sorted
	 */
	public static void bubbleSort(Integer[] a) {
		boolean swapped = false;
		
		
		do {
			swapped = false;
			
			for (int i = 0; i < a.length-1; i++) {
				if ((a[i] != null && a[i+1] != null) && a[i] > a[i + 1]) { // swap
					a[i] = a[i] ^ a[i + 1];
					a[i + 1] = a[i] ^ a[i + 1];
					a[i] = a[i] ^ a[i + 1];
					swapped = true;
				}
			}
		} while(swapped);
	}
}
