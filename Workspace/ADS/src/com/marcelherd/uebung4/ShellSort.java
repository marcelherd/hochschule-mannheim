package com.marcelherd.uebung4;

import java.util.Arrays;

import com.marcelherd.uebung3.Aufgabe3;

import static gdi.MakeItSimple.*;

public class ShellSort {
	public static void main(String[] args) {
		int[] protocoll = new int[] { 0, 0 };
		int[] F;

		// values for h-sorting 9, 4, 3, 1

		F = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29 }; // "zufÃ¤lliges"
																										// Feld
		// # Vergleiche: 99 # Vertauschungen: 39

		F = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // F ist schon sortiert
		// # Vergleiche: 23 # Vertauschungen: 0

		F = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }; // F ist umgekehrt
															// sortiert
		// # Vergleiche: 27 # Vertauschungen: 9

		F = new int[] { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 }; // F ist alternierend,
															// umgekehrt
															// sortiert
		// # Vergleiche: 29 # Vertauschungen: 11

//		F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 }; // F ist fast sortiert
															// - das kleinste
															// Element steht
															// ganz rechts
		// # Vergleiche: 29 # Vertauschungen: 9

//		F = new int[] { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 }; // F besteht aus 2
															// sortierten
															// Teilfolgen
		// # Vergleiche: 29 # Vertauschungen: 13

//		F = new int[] { 10, 2, 3, 4, 5, 6, 7, 8, 9, 1 }; // F ist fast sortiert
															// - nur min und max
															// haben ihre
															// Position
															// vertauscht
		// # Vergleiche: 23 # Vertauschungen: 1

//		F = new int[] { 1 };
		// # Vergleiche: 0 # Vertauschungen: 0

//		F = new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // F ist fast sortiert
															// - das grÃ¶ÃŸte
															// Element steht
															// ganz links
		// # Vergleiche: 28 # Vertauschungen: 9

//		 F = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }; // F ist sortiert -
		// alle
		// Elemente sind gleich
		// # Vergleiche: 23 # Vertauschungen: 0
		shellSort(F, protocoll);
		println(Aufgabe3.arrayToString(F));

		println("Number of permutations: " + protocoll[1]);
		println("Number of key comparisons: " + protocoll[0]);
	}

	public static void shellSort(int[] array, int[] protocoll) {
		if (array.length > 4) {
			if (array.length > 7) {
				if (array.length > 9) {
					sort(array, 9, protocoll);
				} else {
					sort(array, 7, protocoll);
				}
			} else {
				sort(array, 4, protocoll);
			}
		}

		insertionSort(array, protocoll);
	}

	public static void sort(int[] array, int h, int[] protocoll) {
		if (h == 1) {
			return;
		}
		int[][] sliced = slice(array, h);
		for (int i = 0; i < sliced.length; i++) {
			insertionSort(sliced[i], protocoll);
		}
		array = merge(sliced);
		if (h == 9) {
			sort(array, h - 2, protocoll);
		} else {
			sort(array, h - 3, protocoll);
		}
	}

	public static int[][] slice(int[] array, int h) {
		int[][] sliced = new int[h][];
		int stopValue = (array.length-1)%h+1;
		int maxRows = array.length/h;
		if(array.length%h!=0){
			maxRows++;
		}
		for(int i = 0; i<sliced.length; i++){
			if(i<stopValue){
				sliced[i] = new int[maxRows];
			}else{
				sliced[i] = new int[maxRows-1];
			}
		}
			int usedValues = 0;
			int currentRow = 0;
			int i = 0;
			while(usedValues<array.length){
				sliced[i][currentRow] = array[usedValues];
				usedValues++;
				i++;
				if(i>=sliced.length){
					currentRow++;
					i=0;
				}
			}
		
		return sliced;
	}

	public static int[] merge(int[][] array) {
		int validValues = 0;
		for(int i = 0; i<array.length; i++){
			for(int j = 0; j<array[i].length; j++){
				validValues++;
			}
		}
		int[] merged = new int[validValues];
		int mergedIndex = 0;
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array[i].length; j++) {
//			
//					merged[mergedIndex] = array[i][j];
//					mergedIndex++;
//			}
//		}
		
		int usedValues = 0;
		int currentRow = 0;
		int i = 0;
		while(usedValues<merged.length){
			merged[mergedIndex] = array[i][currentRow];
			usedValues++;
			i++;
			mergedIndex++;
			if(i>=array.length){
				currentRow++;
				i=0;
			}
		}

		
		return merged;

	}

	public static void insertionSort(int[] array, int[] protocoll) {

		Aufgabe3.arrayToString(array);
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int toBeInserted = array[i]; // remember the element that is to be
											// inserted
			int originJ = j;
			while (j > 0 && array[j - 1] > toBeInserted) { // key
																								// comparison
				protocoll[0]++;
				array[j] = array[j - 1]; // shifting elements 'to the right' ->
											// permutation
				protocoll[1]++;
				j -= 1;
			}

				protocoll[0]++; // Don't forget the break condition comparison

			if (j != originJ) {
				array[j] = toBeInserted; // permutation
				protocoll[1]++;
			}
		}
	}

}
