package com.marcelherd.uebung4;

import static gdi.MakeItSimple.println;

import java.util.Random;

import com.marcelherd.uebung3.Aufgabe3;

public class QuickSort {

	public static void main(String[] args) {

int [] F;
		
		
		F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufÃ¤lliges" Feld
//		# Rekursionen: 14 # Vergleiche: 64  # Vertauschungen: 31
		testSolve(F);
		F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 0	
//		testSolve(F);
  	    F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 5
//  	  testSolve(F);

		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Rekursionen: 6 # Vergleiche: 21  # Vertauschungen: 9
//		testSolve(F);
		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		# Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 9
//		testSolve(F);
		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//		# Rekursionen: 7 # Vergleiche: 25  # Vertauschungen: 5
//		testSolve(F);

		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		# Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 1
//		testSolve(F);
		F = new int[] {1};
//		# Rekursionen: 0 # Vergleiche: 0  # Vertauschungen: 0		
//		testSolve(F);
		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das grÃ¶ÃŸte Element steht ganz links
//		# Rekursionen: 7 # Vergleiche: 37  # Vertauschungen: 9	
//		testSolve(F);
		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 0	
//		testSolve(F);


		
		
		
	}
	
	public static void testSolve(int[] F){
		int[] prot = new int[]{-1, 0, 0};
		println("Old: " + Aufgabe3.arrayToString(F) + "\n");
		quickSort(F, 0, F.length-1, prot);
		println("New: " + Aufgabe3.arrayToString(F) + "\n");
		println("# Rekusionen: " + prot[0] + " # Vergleiche " + prot[1] + " # Vertauschungen: " + prot[2]);
		println();
	}
	
	public static void quickSort(int[] F, int u, int o, int[] prot){
		
		if(o>u && F.length>1){
			int i = split(F, u, o, prot);
			quickSort(F, u, i-1, prot);
			quickSort(F, i+1, o, prot);
		}
		if(prot[0]<0){
			prot[0]=0;
		}
	}
	
	public static int split(int[] F, int u, int o, int[] prot){
		int p = o;
		int index = u;
		for(int zeiger = u; zeiger<o; zeiger++){
			// swap
			if(F[zeiger] <= F[p]){
			
				swap(F, index, zeiger, prot);
				index++;
			}
			prot[1]++;
		}
		swap(F, index, p, prot);
		prot[0]++;

		return index;
	}
	
	/**
	 * Swaps two Integers in an Array
	 * 
	 * @param F Array in which two Integers will be swapped
	 * @param indexOne The index of the first Integer
	 * @param indexTwo The index of the second Integer
	 * @param prot Holder for protocoll data
	 */
	
	public static void swap(int[] F, int indexOne, int indexTwo, int[] prot){
		if(F[indexOne]==F[indexTwo]){
			return;
		}
		println(arrayToString(F, indexOne, indexTwo));
		F[indexOne] = F[indexOne]^F[indexTwo];
		F[indexTwo] = F[indexOne]^F[indexTwo];
		F[indexOne] = F[indexOne]^F[indexTwo];
		prot[2]++;
	}
	
	/**
	 * Generates a string representation of an array as per the example on Blatt 3 Aufgabe 4.
	 * Includes highlighting support for swapped indices.
	 * 
	 * @param array
	 * @param firstIndex Index of the first number that should be highlighted
	 * @param secondIndex Index of the second number that should be highlighted
	 * @return String representation of array
	 */
	public static String arrayToString(int[] array, int firstIndex, int secondIndex) {
		String retval = "F" + " =\t";
		
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
