package com.marcelherd.uebung4;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

/**
 * Diese Klasse sortiert eine Folge mittels direktem Mergesort.
 * 
 * @author Marcel Herd
 * @author Firas Romdhane
 * @author Manuel Schwalm
 */
public class MergeSort {

	private static final int FILE_TYPE_LENGTH = 4; // ".txt".length()

	private static final String SEQUENCE_ODD_APPEND = "_f1";
	private static final String SEQUENCE_EVEN_APPEND = "_f2";

	public static void main(String[] args) {
		print("Bitte geben Sie die Datei an, die sortiert werden soll: ");
		String path = readLine();

		if (isFilePresent(path) && isFileReadable(path)) {
			sort(path);
		}

		// Die erste Zahl auf der Datei gibt die Anzahl der folgenden Zahlen an.
		// Sie können die Zahl aber auch als ganz normalen Wert interpretieren.
		// Sollte am Ende einer Datei ein Leerzeichen stehen, dann löschen Sie
		// das von Hand.

	}

	public static void sort(String path) {
		Object file = openInputFile(path);
		int[] array = readSequenceFromFile(file);
		closeInputFile(file);

		int aktuelle_lauflaenge = 1;
		while (aktuelle_lauflaenge < array.length) {
			split(array, path);
			
			// clear output file
			Object sortedFile = openOutputFile(path);
			println(sortedFile);
			closeOutputFile(sortedFile);

			// for (;;) { // for 1. Lauf to letzter Lauf do
			// while (true) { // Lauf der Länge tl in F1 oder F2 noch nicht
			// abgearbeitet
			// Entferne das kleinere Anfangselement aus F1 bzw F2
			// Füge dieses an F an
			// }

			// Füge den verbliebenen nichtleeren Rest des aktuellen Laufs von F1
			// oder F2 an F an
			// }

			aktuelle_lauflaenge *= 2;
		}

		
	}

	/**
	 * 
	 * @param array
	 *            Integer sequence that will be split
	 * @param path
	 *            Path of the file that is being sorted. File names for odd and even sequence will
	 *            be generated based upon this.
	 */
	public static void split(int[] array, String path) {
		String oddPath = appendToTxtFileName(SEQUENCE_ODD_APPEND, path);
		String evenPath = appendToTxtFileName(SEQUENCE_EVEN_APPEND, path);

		Object oddFile = openOutputFile(oddPath);
		Object evenFile = openOutputFile(evenPath);

		for (int i = 0; i < array.length - 1; i += 2) {
			println(oddFile, array[i]);
			println(evenFile, array[i + 1]);
		}
		
		// correction for a sequence with an odd amount of elements
		if ((array.length % 2) != 0) {
			println(oddFile, array[array.length - 1]); // simply print the last element extra
		}

		closeOutputFile(evenFile);
		closeOutputFile(oddFile);
	}

	public static void merge() {

	}

	/**
	 * welche ein Band (d.h eine Datei) in geeigneter Form (mit Kennzeichnung der runs) ausgibt, um
	 * einzelne Arbeitsschritte zu protokollieren.
	 */
	public static void printruns() {

	}

	/**
	 * Constructs an integer sequence from file contents
	 * 
	 * @param file File which contains the sequence
	 * @return int[] Integer sequence
	 */
	public static int[] readSequenceFromFile(Object file) {
		// Read file contents
		String content = "";
		while (!isEndOfInputFile(file)) {
			content += readLine(file);
		}

		// Construct integer sequence from contents
		String[] retvalString = content.split(" "); // previously implemented in GDI exercise 6
		int[] retval = new int[retvalString.length - 1];
		for (int i = 1; i < retvalString.length; i++) { // first element is to be skipped
			retval[i - 1] = Integer.parseInt(retvalString[i]); // previously implemented in GDI exercise 4
		}
		return retval;
	}

	/**
	 * Appends a String to a file name while retaining the file extension .txt 
	 * String.replace(".txt", append + ".txt") is not an option..
	 * 
	 * @param append
	 *            String that should be appended to the file name
	 * @param path
	 *            String path to .txt file
	 * @return String new
	 */
	public static String appendToTxtFileName(String append, String path) {
		String retval = "";

		for (int i = 0; i < path.length() - FILE_TYPE_LENGTH; i++) {
			retval += path.charAt(i);
		}

		return retval + append + ".txt";
	}

}
