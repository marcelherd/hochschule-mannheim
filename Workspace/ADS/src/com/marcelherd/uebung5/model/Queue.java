package com.marcelherd.uebung5.model;

import java.util.NoSuchElementException;

/**
 * Custom queue implementation, may only contain integers.
 * This interface adheres to the standards set by the official JDK LinkedList interface, wherever it is applicable.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public interface Queue {
	
	/**
	 * Inserts the specified integer into this queue.
	 * 
	 * @param val - integer to insert into this queue
	 */
	void enter(int val);
	
	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException - if the queue is empty
	 */
	int leave() throws NoSuchElementException;
	
	
	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException - if the queue is empty
	 */
	int front() throws NoSuchElementException;
	
	/**
	 * Returns true if this collection contains no elements.
	 * 
	 * @return true if this collection contains no elements
	 */
	boolean isEmpty();
	
	/**
	 * Generates a string representation of the queue.
	 * 
	 * @return the string representation of the queue
	 */
	String toString();

}
