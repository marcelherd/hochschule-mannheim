package com.marcelherd.uebung5.queue;

import java.util.NoSuchElementException;

import com.marcelherd.uebung5.list.LinkedList;
import com.marcelherd.uebung5.list.MyLinkedList;

public class MyQueue implements Queue {
	
	private LinkedList queue;
	
	/**
	 * Allocates a new MyQueue object.
	 */
	public MyQueue() {
		queue = new MyLinkedList();
	}
	
	/**
	 * Allocates a new MyQueue object with an initial element.
	 * 
	 * @param val - initial element in this queue
	 */
	public MyQueue(int val) {
		queue = new MyLinkedList(val);
	}
	
	/**
	 * Returns an empty MyQueue
	 * 
	 * @return an empty MyQueue
	 */
	public static Queue empty() {
		return new MyQueue();
	}

	@Override
	public void enter(int val) {
		queue.addLast(val);
	}

	@Override
	public int leave() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: Queue is empty");
		} else {
			return queue.removeFirst();
		}
	}

	@Override
	public int front() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: Queue is empty");
		} else {
			return queue.getFirst();
		}
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	@Override
	public String toString() {
		return queue.toString();
	}

}
