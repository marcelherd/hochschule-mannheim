package com.marcelherd.uebung4.aufgabe3;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

public class Ringpuffer {
	
	private int[] buffer;
	
	private int head;
	private int tail;
	
	public Ringpuffer(int maxSize) {
		buffer = new int[maxSize];
	}
	
	public synchronized void put(int value) {
		if (head == (tail - 1)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		buffer[head++] = value;
		head = head % buffer.length;
		
		notifyAll();
	}
	
	public synchronized int get() {
		int retval;
		
		int adjTail = tail > head ? tail - buffer.length : tail;
		if (! (adjTail < head)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		
		retval = buffer[tail++];
		tail = tail % buffer.length;
		
		notifyAll();
		
		return retval;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ringpuffer [buffer=");
		builder.append(Arrays.toString(buffer));
		builder.append("]");
		return builder.toString();
	}

}
