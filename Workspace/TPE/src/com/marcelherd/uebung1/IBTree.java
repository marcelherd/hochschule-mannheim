package com.marcelherd.uebung1;

public interface IBTree {
	
	boolean insert(Integer o);
	boolean insert(String filename);
	boolean contains(Integer o);
	int size();
	int height();
	Integer getMax();
	Integer getMin();
	boolean isEmpty();
	void addAll(IBTree otherTree);
	void printInOrder();
	void printPreOrder();
	void printPostOrder();
	void printLevelOrder();

}
