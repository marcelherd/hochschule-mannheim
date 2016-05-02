package com.marcelherd.uebung1.model;

/**
 * B-Tree implementation that is capable of storing all comparable elements.
 * 
 * This data structure keeps data sorted and guarantees searches and insertions in logarithmic time.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public interface BTree {
	
	/**
	 * Inserts the specified element into this tree.
	 * 
	 * @param o - the element to insert
	 * @return true if the element was inserted
	 */
	boolean insert(Comparable o);
	
	/**
	 * Inserts all elements from the specified file into this tree.
	 * 
	 * @param filename - path to the file containing elements
	 * @return true if the elements were inserted
	 */
	boolean insert(String filename);
	
	/**
	 * Returns true if this tree contains the specified element.
	 * 
	 * @param o - element whose presence in this tree is to be tested
	 * @return true if this tree contains the specified element
	 */
	boolean contains(Comparable o);
	
	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	int size();
	
	/**
	 * Returns the height of this tree.
	 * 
	 * @return the height of this tree
	 */
	int height();
	
	/**
	 * Returns the largest element in this tree.
	 * 
	 * @return the largest element in this tree
	 */
	Comparable getMax();
	
	/**
	 * Returns the smallest element in this tree.
	 * 
	 * @return the smallest element in this tree
	 */
	Comparable getMin();
	
	/**
	 * Returns true if this tree contains no elements.
	 * 
	 * @return true if this tree contains no elements
	 */
	boolean isEmpty();
	
	/**
	 * Inserts all elements from another tree into this tree.
	 * 
	 * @param otherTree - another tree, from which all elements should be inserted into this tree
	 */
	void addAll(BTree otherTree);
	
	/**
	 * Prints all elements of this tree in in-order traversing.
	 */
	void printInOrder();
	
	
	/**
	 * Prints all elements of this tree in pre-order traversing.
	 */
	void printPreOrder();
	
	/**
	 * Prints all elements of this tree in post-order traversing.
	 */
	void printPostOrder();
	
	/**
	 * Prints all elements of this tree in level-order traversing.
	 */
	void printLevelOrder();
	
	
	/**
	 * Returns a deep copy of this tree.
	 * 
	 * @return a deep copy of this tree
	 */
	BTree clone();

}
