package com.marcelherd.uebung1.model;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.isFileReadable;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.readLine;

/**
 * Default IBTree implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class BTree implements IBTree {
	
	/*	Kriterien B-Baum:
	*	m = Ordnung
	*	m-2m Elemente / Node
	*	m+1-2m+1 Kinder / Node
	*	Wurzel = Leaf || mindestens 2 Kinder
	*/
	
	private TreeNode root;
	private IBTree[] subTrees = new IBTree[0];
	
	private int order;
	
	public BTree(int order) {
		this.order = order; // TODO we might not need this
		root = new TreeNode(order);
	}

	@Override
	public boolean insert(Integer o) {
		if (isEmpty()) {
			root.getValues()[0] = o;
			return true;
		} else if (subTrees.length == 0) { // found node; node is a leaf
			return insert(o, root);
		} else { // find insert position (node)
			return insert(o, findLeaf(o, root));
		}
	}
	
	private TreeNode findLeaf(Integer o, TreeNode node) {
		if (subTrees.length == 0) { // found node; node is a leaf
			return node;
		}
		
		for (int i = 0; i < node.getValues().length; i++) { // find the next subtree to check
			if (o < node.getValues()[i]) {
				return findLeaf(o, subTrees[i]);
			}
		}
	}
	
	private boolean insert(Integer o, TreeNode node) {
		if (node.insert(o)) return true; // insert successful
		else { // node exploded
			//TODO
		}
		
		return false;
	}

	@Override
	public boolean insert(String filename) {
		if (isFilePresent(filename) && isFileReadable(filename)) {
			Object file = openInputFile(filename);
			
			// read data
			StringBuilder sb = new StringBuilder();
			while ( !isEndOfInputFile(file)) {
				sb.append(readLine(file));
			}
			
			// parse data
			String inputData = sb.toString();
			inputData = inputData.replaceAll("\\s+", ","); // normalize input
			String[] inputStrings = inputData.split(",");
			Integer[] inputValues = new Integer[inputStrings.length];
			for (int i = 0; i < inputStrings.length; i++) {
				inputValues[i] = Integer.parseInt(inputStrings[i]);
			}
			
			// insert data
			for (Integer i : inputValues) {
				insert(i);
			}
			
			return true; // must've worked cause otherwise there would've been an unhandled exception... :)
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(Integer o) {
		if (root.contains(o)) {
			return true;
		}
		
		for (int i = 0; i < subTrees.length; i++){
			if (subTrees[i].contains(o)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int size() {
		int size = root.size();
		
		for (int i = 0; i < subTrees.length; i++){
			size += subTrees[i].size();
		}
		
		return size;
	}

	@Override
	public int height() {
		// BTrees are by definition balanced, therefore all subtrees have the same height
		return ((subTrees.length == 0) ? 1 : subTrees[0].height() + 1);
	}

	@Override
	public Integer getMax() {
		if (isEmpty()) return 0;
		
		return ((subTrees.length == 0) ? root.getMax() : subTrees[subTrees.length - 1].getMax());
	}

	@Override
	public Integer getMin() {
		if (isEmpty()) return 0;
		
		return ((subTrees.length == 0) ? root.getMin() : subTrees[0].getMin());
	}

	@Override
	public boolean isEmpty() {
		return (subTrees.length == 0 && root.isEmpty());
	}

	@Override
	public void addAll(IBTree otherTree) {
		//TODO
	}
	
	@Override
	public void printInOrder() {
		int toReach = subTrees.length / 2;
		for (int i = 0; i < subTrees.length; i++) {
			if (i == toReach){
				System.out.println(root.toString());
			}
			subTrees[i].printInOrder();
		}
		if (subTrees.length == 0) {
			System.out.println(root.toString());
		}
	}

	@Override
	public void printPreOrder() {
		System.out.println(root.toString());
		for (int i = 0; i < subTrees.length; i++){
			subTrees[i].printPreOrder();
		}
	}

	@Override
	public void printPostOrder() {
		for (int i = 0; i < subTrees.length; i++){
			subTrees[i].printPostOrder();
		}
		System.out.println(root.toString());
	}

	@Override
	public void printLevelOrder() {
		//TODO
	}

	public IBTree clone() {
		IBTree retval = new BTree(this.order);
		
		//TODO
		
		return retval;
	}

}
