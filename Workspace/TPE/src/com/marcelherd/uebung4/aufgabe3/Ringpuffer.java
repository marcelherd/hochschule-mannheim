package com.marcelherd.uebung4.aufgabe3;

public class Ringpuffer {
	
	private int[] values;
	
	public Ringpuffer(int maxSize) {
		values = new int[maxSize];
	}
	
	public synchronized void put(int value) {
		
	}
	
	public synchronized int get() {
		return 0;
	}

}
