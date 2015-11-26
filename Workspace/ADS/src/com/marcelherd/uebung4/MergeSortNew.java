package com.marcelherd.uebung4;

import static gdi.MakeItSimple.*;

import com.marcelherd.uebung3.Aufgabe4;


public class MergeSortNew {

	public final static String TEMP_FILE_ONE = "temp/fileOne.txt";
	public final static String TEMP_FILE_TWO = "temp/fileTwo.txt";

	public static void main(String[] args) {
		split("temp/test.txt", 4);
		merge("temp/test.txt", 4);
	}

	public static void mergeSort(String originPath) {

	}

	public static void split(String originPath, int runtime) {
		Object originFile = openInputFile(originPath);
		String originString = readLine(originFile);
		Object outputFileOne = openOutputFile(TEMP_FILE_ONE);
		Object outputFileTwo = openOutputFile(TEMP_FILE_TWO);
		String outputStringOne = "";
		String outputStringTwo = "";
		String[] numbersAsString = originString.split(" ");
		int numberIndex = 0;
		while (numberIndex < numbersAsString.length) {
			for (int i = 0; i < runtime && numberIndex < numbersAsString.length; i++) {
				outputStringOne += numbersAsString[numberIndex];
				if (numberIndex + 1 < numbersAsString.length) {
					outputStringOne += " ";
				}
				numberIndex++;
			}
			for (int i = 0; i < runtime && numberIndex < numbersAsString.length; i++) {
				outputStringTwo += numbersAsString[numberIndex];
				if (numberIndex + 1 < numbersAsString.length) {
					outputStringTwo += " ";
				}
				numberIndex++;
			}
		}
		print(outputFileOne, outputStringOne);
		print(outputFileTwo, outputStringTwo);
		closeOutputFile(outputFileOne);
		closeOutputFile(outputFileTwo);
		closeInputFile(originFile);
	}

	// TODO @Marcle, Splitten klappt wunderbar musst aber nochmal übers mergen schauen. Müdigkeitslevel ist zu hoch
	// gerade xD (2:27)
	public static void merge(String originPath, int runtime) {
		Object originFile = openOutputFile(originPath);
		Object inputFileOne = openInputFile(TEMP_FILE_ONE);
		Object inputFileTwo = openInputFile(TEMP_FILE_TWO);
		String stringOne = readLine(inputFileOne);
		String stringTwo = readLine(inputFileTwo);

		String originOutput = "";
		String[] inputOneAsString = stringOne.split(" ");
		String[] inputTwoAsString = stringTwo.split(" ");

		String[][] tupelOne = new String[inputOneAsString.length / runtime + inputOneAsString.length % 2][runtime];
		int inputOneAsStringIndex = 0;
		for (int i = 0; i < tupelOne.length; i++) {
			for (int j = 0; j < runtime; j++) {
				tupelOne[i][j] = inputOneAsString[inputOneAsStringIndex];
				inputOneAsStringIndex++;
			}
		}
		String[][] tupelTwo = new String[inputTwoAsString.length / runtime + inputTwoAsString.length % 2][runtime];
		int inputTwoAsStringIndex = 0;
		for (int i = 0; i < tupelTwo.length; i++) {
			for (int j = 0; j < runtime && inputTwoAsStringIndex < tupelTwo.length; j++) {
				tupelTwo[i][j] = inputTwoAsString[inputTwoAsStringIndex];
				inputTwoAsStringIndex++;
			}
		}
		for (int i = 0; i < tupelOne.length; i++) {
			sortTupel(tupelOne[i]);
		}
		for (int i = 0; i < tupelTwo.length; i++) {
			sortTupel(tupelTwo[i]);
		}
		int tupelOneIndex = 0;
		int tupelTwoIndex = 0;
		while (tupelOneIndex < tupelOne.length || tupelTwoIndex < tupelTwo.length) {
			if (tupelOneIndex < tupelOne.length) {
				for (int i = 0; i < tupelOne[tupelOneIndex].length; i++) {
					originOutput += tupelOne[tupelOneIndex][i] + " ";
				}
			}

			if (tupelTwoIndex < tupelTwo.length) {
				for (int i = 0; i < tupelTwo[tupelTwoIndex].length; i++) {
					originOutput += tupelTwo[tupelTwoIndex][i] + " ";
				}
			}
		}

		print(originFile, originOutput);
	}

	public static void sortTupel(String[] tupel) {
		int[] tupelAsInteger = new int[tupel.length];
		for (int i = 0; i < tupel.length; i++) {
			tupelAsInteger[i] = Integer.parseInt(tupel[i]);
		}
		Aufgabe4.shakerSort(tupelAsInteger);
		for (int i = 0; i < tupel.length; i++) {
			tupel[i] = tupelAsInteger[i] + "";
		}
	}

}
