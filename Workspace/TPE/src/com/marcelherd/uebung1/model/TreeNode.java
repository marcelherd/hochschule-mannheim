package com.marcelherd.uebung1.model;

/**
 * BTree tree node implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class TreeNode implements Comparable<Integer> {

	private Integer[] values;

	public TreeNode(int order) {
		this.values = new Integer[order * 2];
	}

	public boolean insert(Integer value) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) { // node has space
				values[i] = value;
				bubbleSort(values); // fix order, this is possible because the node is guaranteed to be a leaf
				return true; // value was inserted
			}
		}
		
		return false; // could not find insert position, node explodes
	}

	public boolean contains(Integer value) {
		for (int i = 0; i < values.length; i++) {
			if (value.compareTo(values[i]) == 0) {
				return true;
			}
		}
		
		return false;
	}

	public int size() {
		int size = 0;
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) size++;
		}
		
		return size;
	}
	
	public boolean isEmpty() {
		return values[0] == null;
	}

	public int getMin() {
		return values[0];
	}
	
	public int getMax() {
		int retval = values[0];
		
		for (int i = 1; i < values.length; i++) {
			if (values[i] != null) {
				retval = values[i];
			} else {
				break;
			}
		}
		
		return retval;
	}
	
	@Override
	public int compareTo(Integer value) {
		if (values[values.length - 1].compareTo(value) > 0) {
			return 1;
		} else if (values[values.length - 1].compareTo(value) < 0) {
			return -1;
		}
		return 0;
	}
	
	public Integer[] getValues() {
		return values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] != null) {
				sb.append(values[i] + " | ");
			} else {
				sb.append("  | ");
			}
		}
		
		if (values[values.length - 1] != null) {
			sb.append(values[values.length - 1]);
		}
		
		return sb.toString();
	}

	/**
	 * Sorts the given array using bubble sort algorithm
	 * 
	 * @param a - array that is to be sorted
	 */
	private void bubbleSort(Integer[] a) {
		boolean swapped = false;
		do {
			swapped = false;
			
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) { // swap
					a[i] = a[i] ^ a[i + 1];
					a[i + 1] = a[i] ^ a[i + 1];
					a[i] = a[i] ^ a[i + 1];
					swapped = true;
				}
			}
		} while(swapped);
	}
}
