package com.marcelherd.uebung4.quicksort;

public class Application {
public static void main(String[] args) {
	QuickSort test = new QuickSort();
	Integer[] testArray = QuickSort.getIntegerArray("D:/test/randoms.txt");
	test.sort(testArray);
	while(!QuickSort.checkSorted(testArray)){
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	System.out.println(test.toString());
}
}
