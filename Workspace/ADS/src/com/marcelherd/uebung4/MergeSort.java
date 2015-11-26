package com.marcelherd.uebung4;

import static gdi.MakeItSimple.*;

import com.marcelherd.uebung3.Aufgabe4;

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
	}

	public static void sort(String path) {
		Object file = openInputFile(path);
		int[] array = readOriginSequenceFromFile(file);
		closeInputFile(file);

		int bubbleSize = 1;

		while (bubbleSize < array.length) {
			split(array, bubbleSize, path);
			merge(array, bubbleSize, path);
			printruns(bubbleSize, path);
			bubbleSize *= 2;
		}
	}

	public static void split(int[] array, int bubbleSize, String path) {
		String oddPath = appendToTxtFileName(SEQUENCE_ODD_APPEND, path);
		String evenPath = appendToTxtFileName(SEQUENCE_EVEN_APPEND, path);

		Object oddFile = openOutputFile(oddPath);
		Object evenFile = openOutputFile(evenPath);

		boolean printToOdd = true;
		for (int i = 0, j = 0; i < array.length; i++, j++) {
			if (j == bubbleSize) {
				printToOdd = !printToOdd;
				j = 0;
			}

			if (printToOdd) {
				print(oddFile, array[i] + " ");
			} else {
				print(evenFile, array[i] + " ");
			}
		}

		closeOutputFile(evenFile);
		closeOutputFile(oddFile);
	}

	public static void merge(int[] array, int bubbleSize, String path) {
		String oddPath = appendToTxtFileName(SEQUENCE_ODD_APPEND, path);
		String evenPath = appendToTxtFileName(SEQUENCE_EVEN_APPEND, path);

		Object oddFile = openInputFile(oddPath);
		Object evenFile = openInputFile(evenPath);
		Object originFile = openOutputFile(path);

		int[] oddArray = readSequenceFromFile(oddFile);
		int[] evenArray = readSequenceFromFile(evenFile);

		int[] sortedArray = new int[bubbleSize * 2];
		int numbersChecked = 0;
		int currentNumberOdd = 0;
		int currentNumberEven = 0;
		while (numbersChecked < oddArray.length || numbersChecked < evenArray.length) {
			for (int i = 0; i < sortedArray.length; i++) {
				sortedArray[i] = Integer.MIN_VALUE;
			}
			for (int i = numbersChecked; i < numbersChecked + bubbleSize * 2; i++) {
				if (i < bubbleSize + numbersChecked && currentNumberOdd < oddArray.length) {
					sortedArray[i - numbersChecked] = oddArray[currentNumberOdd];
					currentNumberOdd++;
				} else if (currentNumberEven < evenArray.length) {
					sortedArray[i - numbersChecked] = evenArray[currentNumberEven];
					currentNumberEven++;
				}
			}
			numbersChecked += bubbleSize;
			Aufgabe4.shakerSort(sortedArray);
			for (int i = 0; i < sortedArray.length; i++) {
				if (sortedArray[i] != Integer.MIN_VALUE) {
					print(originFile, sortedArray[i] + " ");
				}
			}
		}

		closeOutputFile(originFile);
		closeInputFile(oddFile);
		closeInputFile(evenFile);
	}

	/**
	 * Constructs an integer sequence from file contents First element is used
	 * as length indicator only and therefore skipped
	 * 
	 * @param file
	 *            File which contains the sequence
	 * @return int[] Integer sequence
	 */
	public static int[] readOriginSequenceFromFile(Object file) {
		// Read file contents
		String content = "";
		while (!isEndOfInputFile(file)) {
			content += readLine(file);
		}

		// Construct integer sequence from contents
		String[] retvalString = content.split(" "); // previously implemented in
													// GDI exercise 6
		int[] retval = new int[retvalString.length - 1];
		for (int i = 1; i < retvalString.length; i++) { // first element is to
														// be skipped
			retval[i - 1] = Integer.parseInt(retvalString[i]); // previously
																// implemented
																// in GDI
																// exercise 4
		}
		return retval;
	}

	/**
	 * Constructs an integer sequence from file contents
	 * 
	 * @param file
	 *            File which contains the sequence
	 * @return int[] Integer sequence
	 */
	public static int[] readSequenceFromFile(Object file) {
		// Read file contents
		String content = "";
		while (!isEndOfInputFile(file)) {
			content += readLine(file);
		}

		// Construct integer sequence from contents
		String[] retvalString = content.split(" "); // previously implemented in
													// GDI exercise 6
		int[] retval = new int[retvalString.length];
		for (int i = 0; i < retvalString.length; i++) { // first element is to
														// be skipped
			retval[i] = Integer.parseInt(retvalString[i]); // previously
															// implemented in
															// GDI exercise 4
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

	/**
	 * Removes an element from an array and returns a copy of it with length - 1
	 * 
	 * @param array
	 *            array to be modified
	 * @param index
	 *            to be removed from array
	 * @return Copy of array without value at specified index
	 */
	public static int[] removeFromArray(int[] array, int index) {
		int[] retval = new int[array.length - 1];
		int skipped = 0;
		for (int i = 0; i < array.length; i++) {
			if (i != index) {
				retval[i - skipped] = array[i];
			} else {
				skipped++;
			}
		}

		return retval;
	}

	/**
	 * Prints the current run formatted as in ADS Ch. 5 slide 42
	 * 
	 * @param bubbleSize
	 *            Current bubble size
	 * @param path
	 *            Path to the file being sorted
	 */
	public static void printruns(int bubbleSize, String path) {
		Object file = openInputFile(path);

		int[] array = readSequenceFromFile(file);

		for (int i = 0, j = 0; i < array.length; i++, j++) {
			if ((j % bubbleSize) == 0) {
				print("(");
			}

			String delimiter = ((j % bubbleSize) < bubbleSize - 1) ? "," : "";
			print(array[i] + delimiter);

			if ((j % bubbleSize) == bubbleSize - 1) {
				print(")");
			}
		}

		print("\n");

		closeInputFile(file);
	}

}
