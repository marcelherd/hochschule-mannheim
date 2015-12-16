package com.marcelherd.uebung6;

import java.util.NoSuchElementException;

/**
 * Custom binary tree implementation, may only contain integers.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public interface BinaryTree {
	
	/**
	 * Inserts the specified integer.
	 * Duplicate keys are ignored.
	 * 
	 * @param val - the integer to insert
	 * @return true if this tree changed as a result of the call
	 */
	boolean insert (int val);
	
	/**
	 * Inserts the integers in the specified file
	 * 
	 * @param filename - path to the file which contains the integers
	 * @return true if this tree changed as a result of the call
	 */
	boolean insert (String filename);
	
	/**
	 * Returns true if this tree contains the specified integer.
	 * 
	 * @param val - integer whose presence in this tree is to be tested
	 * @return true if this tree contains the specified integer
	 */
	boolean contains(int val);
	
	/**
	 * Returns the amount of nodes that are in this tree.
	 * 
	 * @return the amount of nodes that are in this tree
	 */
	int size();
	
	/**
	 * Returns the height of this tree.
	 * Height := highest level of a leaf + 1
	 * 
	 * @return the height of this tree
	 */
	int height();
	
	/**
	 * Returns the largest integer in this tree.
	 * 
	 * @return the largest integer in this tree
	 * @throws NoSuchElementException - if this tree is empty
	 */
	int getMax() throws NoSuchElementException;
	
	/**
	 * Returns the smallest integer in this tree.
	 * 
	 * @return the smallest integer in this tree
	 * @throws NoSuchElementException - if this tree is empty
	 */
	int getMin() throws NoSuchElementException;
	
	/**
	 * Removes (the node containing) the specified integer from this tree.
	 * 
	 * @param val - the integer that is to be removed from this tree
	 * @return true if this tree changed as a result of the call
	 */
	boolean remove (int val);
	
	/**
	 * Returns true if this tree contains no integers.
	 * 
	 * @return true if this tree contains no integers
	 */
	boolean isEmpty();
	
	/**
	 * Adds all integers from otherTree to this tree
	 * 
	 * @param otherTree - other tree containing integers that are to be added
	 * @return true if this tree changed as a result of the call
	 */
	boolean addAll(BinaryTree otherTree);
	
	/**
	 * Prints this tree inorder to stdout.
	 */
	void printInorder();
	
	/**
	 * Prints this tree postorder to stdout.
	 */
	void printPostorder();
	
	/**
	 * Prints this tree preorder to stdout.
	 */
	void printPreorder();
	
	/**
	 * Prints this tree levelorder to stdout.
	 */
	void printLevelorder();
	
	/**
	 * Returns a deep copy of this BinaryTree.
	 * 
	 * @return a deep copy of this BinaryTree instance
	 */
	BinaryTree clone();

}
