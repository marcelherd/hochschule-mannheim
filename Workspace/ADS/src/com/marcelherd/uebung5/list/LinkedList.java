package com.marcelherd.uebung5.list;

import java.util.NoSuchElementException;

/**
 * Custom singly linked list implementation, may only contain integers.
 * This interface adheres to the standards set by the official JDK LinkedList interface, wherever it is applicable.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public interface LinkedList {
	
	/**
	 * Inserts the specified integer at the beginning of this list.
	 * 
	 * @param val - the integer to add
	 */
	void addFirst(int val);
	
	/**
	 * Appends the specified integer to the end of this list.
	 * 
	 * @param val - the integer to add
	 */
	void addLast(int val);
	
	/**
	 * Removes and returns the first integer from this list.
	 * 
	 * @return the first integer from this list
	 * @throws NoSuchElementException - if the list is empty
	 */
	int removeFirst() throws NoSuchElementException;	
	
	/**
	 * Removes and returns the last integer from this list.
	 * 
	 * @return the last integer from this list
	 * @throws NoSuchElementException - if the list is empty
	 */
	int removeLast() throws NoSuchElementException;
	
	/**
	 * Returns the first integer in this list.
	 * 
	 * @return the first integer in this list
	 * @throws NoSuchElementException - if the list is empty
	 */
	int getFirst() throws NoSuchElementException;
	
	/**
	 * Returns the last integer in this list.
	 * 
	 * @return the last integer in this list
	 * @throws NoSuchElementException - if the list is empty
	 */
	int getLast() throws NoSuchElementException;
	
	/**
	 * Returns true if this collection contains no integers.
	 * 
	 * @return true if this collection contains no integers
	 */
	boolean isEmpty();
	
	/**
	 * Returns true if this list contains the specified integer.
	 * 
	 * @param val - integer whose presence in this list is to be tested
	 * @return true if this list contains the specified integer
	 */
	boolean contains(int val);
	
	/**
	 * Removes all of the integers from this list. 
	 * The list will be empty after this call returns.
	 * 
	 * @return empty LinkedList
	 */
	LinkedList clear();
	
	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	int size();
	
	/**
	 * Returns a shallow copy of this LinkedList. (The elements themselves are not cloned.)
	 * 
	 * @return a shallow copy of this LinkedList instance
	 */
	LinkedList clone();
	
	/**
	 * Deletes the integer at the specified position in this list. 
	 * Shifts any subsequent integers to the left (subtracts one from their indices). 
	 * Returns the integer that was removed from the list.
	 * 
	 * @param index - the index of the integer to be removed
	 * @return the integer previously at the specified position
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	int delete(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Generates a string representation of the list.
	 * 
	 * @return the string representation of the list
	 */
	String toString();
	
	/**
	 * Inserts the specified integer at the specified position in this list.
	 * 
	 * @param index - index at which the integer is to be inserted
	 * @param element - integer that is to be inserted
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	void add(int index, int element) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the integer at the specified position in this list.
	 * 
	 * @param index - index of the integer to return
	 * @return the integer at the specified position in this list
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	int get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns an array containing all of the integers in this list.
	 * 
	 * @return an array containing all of the integers in this list
	 */
	int[] toArray();
	
	/**
	 * Returns a deep copy of this LinkedList.
	 * 
	 * @return a deep copy of this LinkedList instance
	 */
	LinkedList cloneDeep();
	
	/**
	 * Appends all of the integers in otherList to the end of this list.
	 * 
	 * @param otherList LinkedList containing integers to be added to this list
	 * @return true if this list changed as a result of the call
	 */
	boolean addAll(LinkedList otherList);
	
	/**
	 * Creates a new LinkedList that is the concatenation of this list and otherList
	 * 
	 * @param otherList - another LinkedList that should be concatenated with this list
	 * @return a new LinkedList that is the concatenation of this list and otherList
	 */
	LinkedList concat(LinkedList otherList);

}
