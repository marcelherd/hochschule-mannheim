package com.marcelherd.uebung3;

public class Aufgabe1 {

	public static void main(String[] args) {

	}

	public static int linearSearchComplete(int toSearch, int[] toBrowse) {
		int index = -1;
		for (int i = 0; i < toBrowse.length; i++) {
			if (toBrowse[i] == toSearch) {
				index = i;
			}
		}
		return index;
	}

	public static int linearSearchUntilFirst(int toSearch, int[] toBrowse) {
		int index = -1;
		boolean found = false;
		for (int i = 0; i < toBrowse.length && !found; i++) {
			if (toBrowse[i] == toSearch) {
				index = i;
				found = true;
			}
		}
		return index;
	}

	public static int binarySearchRecursively(int toSearch, int[] toBrowse, int u, int o) {
		int noKey = -1;
		int actualIndex = (u + o) / 2;
		if (o - u <= 0) {
			return noKey;
		}
		if (toSearch == toBrowse[actualIndex]) {

			return actualIndex;
		} else if (toSearch > toBrowse[actualIndex]) {
			u = actualIndex + 1;
		} else {
			o = actualIndex - 1;
		}

		return binarySearchRecursively(toSearch, toBrowse, u, o);

	}

	public static int binarySearchIteraly(int toSearch, int[] toBrowse) {
		int noKey = -1;
		int u = 0;
		int o = toBrowse.length - 1;
		int actualIndex = (u + o) / 2;

		while (o - u >= 0) {
			actualIndex = (u + o) / 2;
			if (toSearch == toBrowse[actualIndex]) {

				return actualIndex;
			} else if (toSearch > toBrowse[actualIndex]) {
				u = actualIndex + 1;
			} else {
				o = actualIndex - 1;
			}
		}
		return noKey;
	}
}
