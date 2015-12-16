package com.marcelherd.uebung6;

import static gdi.MakeItSimple.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyBinaryTree implements BinaryTree {
	
	private TreeNode root;
	
	public MyBinaryTree() {
		root = null;
	}
	
	public MyBinaryTree(int val) {
		root = new TreeNode(val);
	}

	/**
	 * Returns an empty MyBinaryTree
	 * 
	 * @return an empty MyBinaryTree
	 */
	public static BinaryTree empty() {
		return new MyBinaryTree();
	}

	@Override
	public boolean insert(int val) {
		if (isEmpty()) {
			root = new TreeNode(val);
			return true;
		} else {
			TreeNode parent = null;
			TreeNode child = root;
			
			// find parent node
			while (child != null) {
				parent = child;
				
				if (child.compareTo(val) == 0) { // child (parent) == val
					return false; // duplicate key
				} else if (child.compareTo(val) < 0) { // child (parent) < val
					child = child.getRight(); // insert in right tree
				} else { // child (parent) > val
					child = child.getLeft(); // insert in left tree
				}
			}
			
			if (parent.compareTo(val) < 0) { // parent < val
				parent.setRight(new TreeNode(val));
			} else { // parent > val
				parent.setLeft(new TreeNode(val));
			}
			
			return true;
		}
	}

	@Override
	public boolean insert(String filename) {
		boolean retval = false;
		if (isFilePresent(filename) && isFileReadable(filename)) {
			Object file = openInputFile(filename);
			String line = readLine(file);
			String[] numbers = line.split(" ");
			for (int i = 0; i < numbers.length; i++) {
				int number = Integer.parseInt(numbers[i]);
				retval = insert(number);
			}
			closeInputFile(file);
		}
		return retval;
	}

	@Override
	public boolean contains(int val) {
		// traverse the tree
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (! queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node.getElement() == val) { // process node
				return true;
			}
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		return false;
	}

	@Override
	public int size() {
		int retval = 0;
		
		// traverse the tree
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (! queue.isEmpty()) {
			TreeNode node = queue.remove();
			
			if (node != null) {
				retval++; // process node
				
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
		}
		
		return retval;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMax() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: Tree is empty");
		} else {
			int max = Integer.MIN_VALUE;
			
			// traverse the tree
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (! queue.isEmpty()) {
				TreeNode node = queue.remove();
				max = (node.getElement() > max ? node.getElement() : max); // process node
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			
			return max;
		}
	}

	@Override
	public int getMin() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: Tree is empty");
		} else {
			int min = Integer.MAX_VALUE;
			
			// traverse the tree
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (! queue.isEmpty()) {
				TreeNode node = queue.remove();
				min = (node.getElement() < min ? node.getElement() : min); // process node
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			
			return min;
		}
	}

	@Override
	public boolean remove(int val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean addAll(BinaryTree otherTree) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printInorder() {
		if (isEmpty()) {
			println("Tree is empty.");
		} else {
			printInorder(root);
		}
	}
	
	private void printInorder(TreeNode node) {
		if (node != null) {
			printInorder(node.getLeft());
			print(node.getElement() + " ");
			printInorder(node.getRight());
		}
	}

	@Override
	public void printPostorder() {
		if (isEmpty()) {
			println("Tree is empty.");
		} else {
			printPostorder(root);
		}
	}
	
	private void printPostorder(TreeNode node) {
		if (node != null) {
			printPostorder(node.getLeft());
			printPostorder(node.getRight());
			print(node.getElement() + " ");
		}
	}

	@Override
	public void printPreorder() {
		if (isEmpty()) {
			println("Tree is empty.");
		} else {
			printPreoder(root);
		}
	}
	
	private void printPreoder(TreeNode node) {
		if (node != null) {
			print(node.getElement() + " ");
			printPreoder(node.getLeft());
			printPreoder(node.getRight());
		}
	}

	@Override
	public void printLevelorder() {
		if (isEmpty()) {
			println("Tree is empty.");
		} else {
			printLevelorder(root);
		}
	}
	
	private void printLevelorder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (! queue.isEmpty()) {
			TreeNode node = queue.remove();
			print(node.getElement() + " "); // process node
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	@Override
	public BinaryTree clone() {
		BinaryTree retval = new MyBinaryTree();
		
		// traverse the tree
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (! queue.isEmpty()) {
			TreeNode node = queue.remove();
			retval.insert(node.getElement()); // process node
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		
		return retval;
	}
	
}
