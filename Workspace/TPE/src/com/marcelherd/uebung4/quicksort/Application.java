package com.marcelherd.uebung4.quicksort;
import static gdi.MakeItSimple.*;
import java.util.Random;



public class Application {
public static void main(String[] args) {
	
	QuickSort test = new QuickSort();
	Integer[] testArray;
	testArray = QuickSort.getIntegerArray("resources/randoms.txt");
	int threadsBeforeSort = Thread.activeCount();
	long startTime = System.currentTimeMillis();
	test.sort(testArray);
	while(Thread.activeCount() > threadsBeforeSort){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	startTime = System.currentTimeMillis() - startTime;
	println(test);
	println("Array Sorted: " + QuickSort.checkSorted(testArray));
	println("Time: " + startTime + "ms");
	test.write("resources/randoms_sorted.txt");
	println("written!");
}


public static void createEnormFile(int numbers){
	StringBuilder safer = new StringBuilder();
	Random r = new Random();
	for(int i = 0; i<numbers; i++){
		safer.append((i + r.nextInt(numbers) - (numbers/2)) + " ");
	}
	Object file = openOutputFile("resources/randoms_" + numbers + ".txt");
	print(file, safer.toString());
	closeOutputFile(file);
}
}
