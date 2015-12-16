package com.marcelherd.uebung6;

/**
 * Represents the node of a binary tree, may only contain integers.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public class TreeNode implements Comparable<Integer> {
	
	private int element;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int element) {
		this.element = element;
		left = right = null;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public int compareTo(Integer o) {
		if (element == o.intValue()) {
			return 0;
		} else if (element < o.intValue()) {
			return -1;
		} else { // element > o
			return 1;
		}
	}

}
