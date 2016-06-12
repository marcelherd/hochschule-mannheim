package com.marcelherd.uebung4.quicksort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	
	private QuickSort quickSort;
	
	@Before
	public void setUp(){
		quickSort = new QuickSort();
	}
	
	@Test
	public void getProtocolTestEmpty(){
		assertArrayEquals(quickSort.getProtocol(), new int[]{0,0,0,0});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getProtocollTestTooBigIndex(){
		quickSort.getProtocol(4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getProtocollTestTooSmallIndex(){
		quickSort.getProtocol(-1);
	}
	
	@Test
	public void getProtocollTestBiggestIndex(){
		quickSort.getProtocol(3);
	}
	
	@Test
	public void getProtocollTestSmallestIndex(){
		quickSort.getProtocol(0);
	}
	
	@Test
	public void sortTestEmptyArray(){
		quickSort.sort(new Integer[]{});
	}
	
	@Test
	public void sortTestReversedArray(){
		Integer[] testArray = new Integer[]{10,9,8,7,6,5,4,3,2,1,0};
		quickSort.sort(testArray);
		while(!QuickSort.checkSorted(testArray)){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertArrayEquals(testArray, new Integer[]{0,1,2,3,4,5,6,7,8,9,10});
	}
	
	@Test
	public void sortTestGiantFile(){
		Integer[] array = QuickSort.getIntegerArray("resources/randoms.txt");
		int activeThreadsBefore = Thread.activeCount();
		quickSort.sort(array);
		
		// Because before sorting, there were activeThreadsBefore Threads active.
		while(Thread.activeCount() > activeThreadsBefore){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(true, QuickSort.checkSorted(array));
	}
	
	@Test
	public void checkSortedTestEmptyArray(){
		assertEquals(true, QuickSort.checkSorted(new Comparable[]{}));
	}
	
	@Test
	public void getIntegerArrayTestEmptyFile(){
		Integer[] testArray = QuickSort.getIntegerArray("resources/testEmpty.txt");
		assertArrayEquals(new Integer[]{}, testArray);
	}
	
	@Test
	public void getIntegerArrayTestGiantFile(){
		QuickSort.getIntegerArray("resources/randoms.txt");
	}
	
}
