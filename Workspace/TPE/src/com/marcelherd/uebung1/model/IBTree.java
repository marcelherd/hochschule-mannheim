package com.marcelherd.uebung1.model;

/**
 * B-Tree implementation that is capable of storing Integers.
 * 
 * This data structure keeps data sorted and guarantees searches and insertions in logarithmic time.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public interface IBTree {
	
	/**
	 * Inserts the specified integer into this tree.
	 * 
	 * @param o - the integer to insert
	 * @return
	 */
	boolean insert(Integer o);
	
	/**
	 * Inserts all integers from the specified file into this tree.
	 * 
	 * @param filename - path to the file containing integers
	 * @return
	 */
	boolean insert(String filename);
	
	/**
	 * Returns true if this tree contains the specified integer.
	 * 
	 * @param o - integer whose presence in this tree is to be tested
	 * @return true if this tree contains the specified integer
	 */
	boolean contains(Integer o);
	
	/**
	 * Returns the number of integers in this tree.
	 * 
	 * @return the number of integers in this tree
	 */
	int size();
	
	/**
	 * Returns the height of this tree.
	 * 
	 * @return the height of this tree
	 */
	int height();
	
	/**
	 * Returns the largest integer in this tree.
	 * 
	 * @return the largest integer in this tree
	 */
	Integer getMax();
	
	/**
	 * Returns the smallest integer in this tree.
	 * 
	 * @return the smallest integer in this tree
	 */
	Integer getMin();
	
	/**
	 * Returns true if this tree contains no integers.
	 * 
	 * @return true if this tree contains no integers
	 */
	boolean isEmpty();
	
	/**
	 * Inserts all integers from another tree into this tree.
	 * 
	 * @param otherTree - another tree, from which all integers should be inserted into this tree
	 */
	void addAll(IBTree otherTree);
	
	/**
	 * Prints all integers of this tree in in-order traversing.
	 */
	void printInOrder();
	
	
	/**
	 * Prints all integers of this tree in pre-order traversing.
	 */
	void printPreOrder();
	
	/**
	 * Prints all integers of this tree in post-order traversing.
	 */
	void printPostOrder();
	
	/**
	 * Prints all integers of this tree in level-order traversing.
	 */
	void printLevelOrder();
	
	
	/**
	 * Returns a deep copy of this tree.
	 * 
	 * @return a deep copy of this tree
	 */
	IBTree clone();

}
