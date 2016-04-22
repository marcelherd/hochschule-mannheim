package com.marcelherd.uebung1.model;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.isFileReadable;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.readLine;

import com.marcelherd.uebung1.util.Sorting;

/**
 * Default IBTree implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class BTree implements IBTree {
	

	
	private TreeNode root;
	protected BTree[] subTrees = new BTree[0];
	
	public TreeNode getRoot() {
		return root;
	}

	private int order;
	
	public BTree(int order) {
		this.order = order; // TODO we might not need this
		root = new TreeNode(order, null);
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
				return findLeaf(o, subTrees[i].getRoot());
			}
		}
		return subTrees[subTrees.length-1].getRoot();
	}
	
	private boolean insert(Integer o, TreeNode node) {
		if (node.insert(o)) return true; // insert successful
		else { // node exploded
//			node.getParent().handleExplode(findMiddleElement(node.getValues(), o), node);
//			return true;
			
			
			// We don't have a tree, we have a sapling!
			return false;
		}
	}

	

	
//	public void handleExplode(Integer o, TreeNode node){
//			if(!root.insert(o)){
//				root.getParent().handleExplode(findMiddleElement(root.getValues(), o), root);
//				
//			}else{
//				for(int i = 0; i<root.getValues().length; i++){
//					if(root.getValues()[i] == o){
//						// i = position des eingefügten wertes. --> Position des linken Subtrees
//					}
//				}
//			}
//		
//		
//	}
	
	private int findMiddleElement(Integer[] values, Integer o){
		Integer[] newValues = new Integer[values.length+1];
		for(int i = 0; i<values.length; i++){
			newValues[i] = values[i];
		}
		newValues[newValues.length+1] = o;
		Sorting.bubbleSort(newValues);
		// always odd because values.length = 2*m and newValues.length 2*m+1
		return newValues[newValues.length/2];
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
		TreeNode root = ((BTree) otherTree).getRoot();
		for(int i : root.getValues()){
			insert(i);
		}
		for(BTree subTree : ((BTree) otherTree).subTrees){
			addAll(subTree);
		}
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
		System.out.println(root.toString());
	}

	public IBTree clone() {
		IBTree retval = new BTree(this.order);
		
		retval.addAll(this);
		
		return retval;
	}
	

	@Override
	public String toString(){
		String retval = "";
		int toReach = subTrees.length / 2;
		for (int i = 0; i < subTrees.length; i++) {
			if (i == toReach){
				retval += root.toString();
			}
			subTrees[i].printInOrder();
		}
		if (subTrees.length == 0) {
			retval += root.toString();
		}
		return retval;
	}

}
