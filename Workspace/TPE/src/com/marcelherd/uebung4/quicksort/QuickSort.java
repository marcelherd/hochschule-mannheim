package com.marcelherd.uebung4.quicksort;

import static gdi.MakeItSimple.*;

import gdi.MISException;


public class QuickSort implements Runnable, SortAlgorithm {
	/*
	 * Legend: 
	 * protocol[0] = recursion steps 
	 * protocol[1] = swaps 
	 * protocol[2] = comparisons 
	 * protocol[3] = threads created
	 */
	private int[] protocol = new int[] { -1, 0, 0, 0 };
	private Comparable[] array = new Comparable[]{};
	private int lowerBorder;
	private int upperBorder;
	
	/**
	 * 
	 * 
	 * @return a protocol based on this legend:
	 * protocol[0] = recursion steps 
	 * protocol[1] = swaps 
	 * protocol[2] = comparisons
	 * protocol[3] = threads created
	 */
	public int[] getProtocol() {
		return protocol;
	}
	
	/**
	 * Returns one part of the protocol based on the index
	 * 
	 * @param index 
	 * 		based on this an another part of the protocol will be returned.
	 * @return
	 * 		if index = 0 -> recursion steps; 
	 * 		if index = 1 -> swaps; 
	 * 		if index = 2 -> comparisons; 
	 * 		if index = 3 -> threads created
	 * 		
	 * @throws 
	 * 		IllegalArgumentException if index is greater than 3 or lower than 0.
	 */
	public int getProtocol(int index) throws IllegalArgumentException{
		if(index < 0){
			throw new IllegalArgumentException("index must be greater than or equal 0: " + index);
		}else if(index > 3){
			throw new IllegalArgumentException("index must be lower or equal 3: " + index);
		}
		return protocol[index];
	}

	/**
	 * creates an empty QuickSort object to start the sort process
	 */
	public QuickSort() {

	}

	private void start() {
		new Thread(this).start();
	}

	private QuickSort(Comparable[] array, int lowerBorder, int upperBorder, int[] protocol) {
		this.lowerBorder = lowerBorder;
		this.upperBorder = upperBorder;
		this.array = array;
		this.protocol = protocol;
	}

	@Override
	public void sort(Comparable[] array) {
		this.array = array;
		new QuickSort(array, 0, array.length - 1, protocol).start();
	}

	@Override
	public void run() {
		protocol[3]++;
		if (upperBorder > lowerBorder && array.length > 1) {
			protocol[0]++;
			int i = split();
			new QuickSort(array, lowerBorder, i - 1, protocol).start();
			new QuickSort(array, i + 1, upperBorder, protocol).start();
		}
		if (protocol[0] < 0) {
			protocol[0] = 0;
		}
	}

	/**
	 * Splits the array into two (based on the upper and lower border).
	 * 
	 * 
	 * @return an integer which represents the pivot element
	 */
	private int split() {
		int index = lowerBorder;
		for (int zeiger = lowerBorder; zeiger < upperBorder; zeiger++) {
			// swap
			if (array[zeiger].compareTo(array[upperBorder]) < 0) {
				swap(index, zeiger);
				index++;
			}
			protocol[2]++;
		}
		swap(index, upperBorder);

		return index;
	}

	/**
	 * Swaps two Integers in an Array
	 * 
	 * @param array
	 *            Array in which two Integers will be swapped
	 * @param indexOne
	 *            The index of the first Integer
	 * @param indexTwo
	 *            The index of the second Integer
	 * @param protocol
	 *            Holder for protocoll data
	 */

	private void swap(int indexOne, int indexTwo) {
		Comparable temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
		protocol[1]++;
	}
	
	@Override
	public String toString(){
		StringBuilder retval = new StringBuilder();
		for(int i = 0; i<array.length; i++){
			retval.append(array[i].toString() + "\n");
		}
		retval.append("Recursions: " + getProtocol(0));
		retval.append("\nSwaps: " + getProtocol(1));
		retval.append("\nComparisons: " + getProtocol(2));
		retval.append("\nThreads created: " + getProtocol(3));
		
		return retval.toString();
	}

	/**
	 * Reads a file and construct an Integer array
	 * 
	 * @param filepath
	 *            Path to file
	 * @return an array which represents all values of the file in the same
	 *         order
	 */
	public static Integer[] getIntegerArray(String filepath) {
		Integer[] retval;
		if (!isFilePresent(filepath)){
			throw new MISException("File not found: " + filepath);
		}else if(!isFileReadable(filepath)){
			throw new MISException("File is not readable: " + filepath);
		}
			Object file = openInputFile(filepath);
			String fileAsString = "";
			while (!isEndOfInputFile(file)) {
				fileAsString += readLine(file);
			}
			String[] fileAsArray = fileAsString.split(" ");
			retval = new Integer[fileAsArray.length];
			for (int i = 0; i < fileAsArray.length; i++) {
				retval[i] = Integer.valueOf(fileAsArray[i]);
			}
			closeInputFile(file);
			return retval;
	}

	/**
	 * Checks if the array is sorted
	 * 
	 * @param array
	 *            Array which should be checked
	 * @return true if the array is sortet, fale if not
	 */
	public static boolean checkSorted(Comparable[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1].compareTo(array[i]) > 0) {
				return false;
			}
		}
		return true;
	}
}
