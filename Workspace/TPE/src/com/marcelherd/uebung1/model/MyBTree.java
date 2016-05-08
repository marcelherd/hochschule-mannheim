package com.marcelherd.uebung1.model;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.isFileReadable;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.readLine;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.activation.UnsupportedDataTypeException;

/**
 * Default BTree implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class MyBTree implements BTree {
	
	private TreeNode root; // must be either a leaf, or have at least 2 children
	
	private int order;
	
	public MyBTree(int order) {
		this.order = order;
		this.root = new TreeNode(order);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean insert(Comparable o) {
		if (! isEmpty()) {
			if (! o.getClass().equals(root.getKeys()[0].getClass())) { // compare o's type with that of an element within the tree
				/*
				 * Aufgabenstellung:
				 * > Im B-Baum sollen nicht nur Integer-Objekte verwaltet werden, sondern alle Arten von Objekten, 
				 * > die miteinander vergleichbar sind. Es sind immer nur Elemente derselben Klasse miteinander vergleichbar!
				 * 
				 * beißt sich leider mit der Auto Verwaltung. Kompromiss: Auch Elemente, die die selbe, direkte Superklasse haben,
				 * sind miteinander vergleichbar - somit funktioniert die Auto Verwaltung.
				 */
				if (! o.getClass().getGenericSuperclass().getTypeName().equals("java.lang.Object")) { // if o has a superclass that is not Object
					if (! o.getClass().getGenericSuperclass().getTypeName().equals(root.getKeys()[0].getClass().getGenericSuperclass().getTypeName())) { // they don't share a direct superclass
						return false; // o is of a different type than the existing element(s), it can not be inserted
					}
				}
			}
		}
		
		TreeNode newNode = new TreeNode(order);
		Comparable newRootKey = root.insert(o, newNode); // null if explosion was handled within the root TreeNode
		if (newRootKey != null) { // explosion cascaded up to root, create new root node
			TreeNode newRoot = new TreeNode(order);
			newRoot.getKeys()[0] = newRootKey;
			newRoot.getChildren()[0] = root;
			newRoot.getChildren()[1] = newNode;
			root = newRoot;
		}
		
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insert(String filename) {
		if (isFilePresent(filename) && isFileReadable(filename)) {
			Object file = openInputFile(filename);
			
			// read
			StringBuilder sb = new StringBuilder();
			while ( !isEndOfInputFile(file)) {
				sb.append(readLine(file));
			}
			
			// parse
			String inputData = sb.toString();
			inputData = inputData.replaceAll("\\s+", ","); // normalize input
			String[] inputStrings = inputData.split(","); // first string declares data type, subsequent strings are keys
			
			if (inputStrings.length > 1) { // there are keys to insert
				/*
				 * While it would be necessary to use reflection to fully complete the given assignment,
				 * it is simply not feasible. Our best bet is to implement this method for only a select few
				 * Comparable types.
				 */
				try {
					Comparable[] inputValues = new Integer[inputStrings.length - 1];
					
					for (int i = 1; i < inputStrings.length; i++) {
						switch (inputStrings[0]) {
							case "Integer":
								inputValues[i - 1] = Integer.parseInt(inputStrings[i]);
								break;
							case "String":
								inputValues[i - 1] = inputStrings[i];
								break;
							case "Double":
								inputValues[i - 1] = Double.parseDouble(inputStrings[i]);
								break;
							case "Float":
								inputValues[i - 1] = Float.parseFloat(inputStrings[i]);
								break;
							case "Long":
								inputValues[i - 1] = Long.parseLong(inputStrings[i]);
								break;
							default:
								throw new UnsupportedDataTypeException("Unsupported data type: " + inputStrings[0]);
						}
					}
					
					for (Comparable c : inputValues) {
						insert(c);
					}
				} catch (UnsupportedDataTypeException e) {
					System.out.println(e.getMessage());
					return false;
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Comparable obj) {
		if (isEmpty()) return;
		
		// 1. find node that contains obj
		TreeNode target = root;
		TreeNode parent = null;
		while (! target.contains(obj)) {
			if (target.isLeaf()) return; // element is not in tree
			
			for (int i = 0; i < target.getKeys().length; i++) { // find subtree within node
				parent = target;
				if (target.getKeys()[i] == null || obj.compareTo(target.getKeys()[i]) == -1) {
					target = target.getChildren()[i]; // enter left subtree
					break;
				}
				if (obj.compareTo(target.getKeys()[i]) == 1 && i == target.getKeys().length - 1) {
					target = target.getChildren()[target.getKeys().length]; // enter last subtree
					break;
				}
			}
		}
		
		// 2. remove obj from node
		if (target.isLeaf()) {
			int index = target.index(obj);
			target.getKeys()[index] = null; // delete element
			leftShiftKeys(target, index); // shift subsequent elements to the left
			
			if (target.size() < order) { // deficit
				// 3. fix deficit
				handleUnderflow(target, parent);
			}
		} else { // inner node
			int index = target.index(obj);
			parent = target;
			TreeNode thatChild = target.getChildren()[index]; // subtree to the left of obj
			while (! thatChild.isLeaf()) { // find the leaf that contains the next smallest element
				parent = thatChild;
				int treeIndex = 0;
				for (int i = 1; i < thatChild.getChildren().length - 1; i++) {
					if (thatChild.getChildren()[i] == null) break;
					treeIndex = i;
				}
				thatChild = thatChild.getChildren()[treeIndex]; // until we found the leaf, always go for the subtree that is the furthest to the right
			}
			target.getKeys()[index] = thatChild.getMax(); // replace obj
			thatChild.getKeys()[thatChild.index(thatChild.getMax())] = null; // remove replacement from leaf
			leftShiftKeys(thatChild, index); // shift subsequent elements to the left
			
			if (thatChild.size() < order) { // deficit in leaf
				// 3. fix deficit
				handleUnderflow(thatChild, parent);
			}
		}
	}
	
	/**
	 * Fixes underflow within node
	 * 
	 * @param node - node that has a deficit
	 * @param parent - parent of node
	 */
	private void handleUnderflow(TreeNode node, TreeNode parent) {
		if (parent == null) return;
		if (parent == root) {
			TreeNode newRoot = new TreeNode(order);
			
			// build keys for new root
			TreeNode left = parent.getChildren()[0];
			TreeNode right = parent.getChildren()[1];
			Comparable[] newRootKeys = new Comparable[2 * order];
			for (int i = 0; i < left.size(); i++) {
				newRootKeys[i] = left.getKeys()[i];
			}
			newRootKeys[left.size()] = parent.getKeys()[0];
			for (int i = 0; i < right.size(); i++) {
				newRootKeys[i + left.size() + 1] = right.getKeys()[i];
			}
			newRoot.setKeys(newRootKeys);
			
			// build children for new root
			TreeNode[] newRootChildren = new TreeNode[2 * order + 1];
			for (int i = 0; i < left.children(); i++) {
				newRootChildren[i] = left.getChildren()[i];
			}
			for (int i = 0; i < right.children(); i++) {
				newRootChildren[i + left.children()] = right.getChildren()[i];
			}
			newRoot.setChildren(newRootChildren);
			root = newRoot;
			return;
		}
		int nodeIndex = 0;
		for (int i = 0; i < parent.getChildren().length; i++) {
			if (parent.getChildren()[i] == node) {
				nodeIndex = i;
				break;
			}
		}
		
		TreeNode left = (nodeIndex > 0) ? parent.getChildren()[nodeIndex - 1] : null;
		TreeNode right = (nodeIndex < parent.getChildren().length - 1) ? parent.getChildren()[nodeIndex + 1] : null;
		
		if (left != null && left.size() > order) { // balance with left sibling
			Comparable leftKey = left.getMax();
			int leftKeyIndex = left.index(leftKey);
			Comparable parentKey = parent.getKeys()[nodeIndex - 1];
			int parentKeyIndex = parent.index(parentKey);
			rightShiftKeys(node);
			node.getKeys()[0] = parentKey;
			parent.getKeys()[parentKeyIndex] = leftKey;
			left.getKeys()[leftKeyIndex] = null;
		} else if (right != null && right.size() > order) { // balance with right sibling
			Comparable rightKey = right.getMin();
			int rightKeyIndex = right.index(rightKey);
			Comparable parentKey = parent.getKeys()[nodeIndex];
			int parentKeyIndex = parent.index(parentKey);
			node.getKeys()[node.firstAvailableIndex()] = parentKey;
			parent.getKeys()[parentKeyIndex] = rightKey;
			leftShiftKeys(right, rightKeyIndex);
		} else { // merge with sibling ಠ_ಠ
			TreeNode mergedNode = new TreeNode(order);
			Comparable[] newKeys = new Comparable[2 * order];
			
			if (left != null) { // merge with left sibling
				for ( int i = 0; i < left.size(); i++) { // first, insert the keys from the left sibling
					newKeys[i] = left.getKeys()[i];
				}
				Comparable parentKey = parent.getKeys()[nodeIndex - 1];
				int parentKeyIndex = parent.index(parentKey);
				newKeys[left.size()] = parentKey; // then, insert key from parent node
				
				for (int i = 0; i < node.size(); i++) {
					newKeys[i + left.size() + 1] = node.getKeys()[i]; // finally, insert the keys from this node
				}
				
				mergedNode.setKeys(newKeys);
				
				// putting it all together
				int parentIndex = parent.index(left);
				parent.getChildren()[parentIndex] = mergedNode;
				parent.getChildren()[parentIndex + 1] = null;
				parent.getKeys()[parentKeyIndex] = null; // can cause another underflow
				
				if (parent.size() < order) { // deficit
					handleUnderflow(parent, findParent(parent, root));
				}
			} else { // merge with right sibling
				for (int i = 0; i < node.size(); i++) {
					newKeys[i] = node.getKeys()[i]; // first, insert the keys from this node
				}
				Comparable parentKey = parent.getKeys()[nodeIndex];
				newKeys[node.size()] = parentKey; // then, insert key from parent node
				for (int i = 0; i < right.size(); i++) {
					newKeys[i + node.size() + 1] = right.getKeys()[i]; // finally, insert the keys from the right sibling
				}
				
				mergedNode.setKeys(newKeys);
				
				// putting it all together
				leftShiftKeys(parent, 0); // can cause another underflow
				leftShiftChildren(parent);
				parent.getChildren()[0] = mergedNode;
				
				if (parent.size() < order) { // deficit
					handleUnderflow(parent, findParent(parent, root));
				}
			}
		}
	}
	
	/**
	 * Returns the parent of node, or null if node has no parent
	 * 
	 * @param node - node, whose parent is being searched for
	 * @param container - node, within which the parent is being searched for
	 * @return the parent of node, or null if node has no parent
	 */
	private TreeNode findParent(TreeNode node, TreeNode container) {
		if (node == root) return null;
		
		for (TreeNode child : container.getChildren()) { // check if container is the parent of node
			if (child == node) return container;
		}
		
		if (! container.isLeaf()) { // check if a child of the container is the parent of node
			for (TreeNode child : container.getChildren()) {
				TreeNode result = findParent(node, child);
				if (result != null) return result;
			}
		}
		
		return null; // could not find parent
	}
	
	/**
	 * Shifts all children inside the given node to the left
	 * 
	 * @param node - node, whose children should be shifted to the left
	 */
	private void leftShiftChildren(TreeNode node) {
		for (int i = 0; i < node.getChildren().length - 1; i++) {
			node.getChildren()[i] = node.getChildren()[i + 1];
		}
	}
	
	/**
	 * Shifts all keys inside the given node to the left, starting at startIndex
	 * 
	 * @param node - node, whose keys are being shifted
	 * @param startIndex - index where the first shifted key will reside
	 */
	private void leftShiftKeys(TreeNode node, int startIndex) {
		Comparable[] keys = node.getKeys();
		for (int i = startIndex; i < keys.length - 1; i++) {
			keys[i] = keys[i + 1];
		}
		keys[keys.length - 1] = null;
	}
	
	/**
	 * Shifts all keys inside node to the right
	 * 
	 * @param node - node, whose keys are being shifted to the right
	 */
	private void rightShiftKeys(TreeNode node) {
		for (int i = node.getKeys().length - 1; i > 0; i--) {
			node.getKeys()[i] = node.getKeys()[i - 1];
		}
		node.getKeys()[0] = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Comparable o) {
		return contains(o, root);
	}

	/**
	 * Returns true if this tree contains the specified element.
	 * 
	 * @param o - element whose presence in this tree is to be tested
	 * @param node - node, within which element is being searched for
	 * @return true if this tree contains the specified element
	 */
	private boolean contains(Comparable o, TreeNode node) {
		if (node == null) return false;
		
		for (int i = 0; i < node.getKeys().length; i++) { // check current node
			if (node.getKeys()[i] != null && o.compareTo(node.getKeys()[i]) == 0) {
				return true;
			}
		}
		
		for (int i = 0; i < node.getChildren().length; i++) { // check children
			if (contains(o, node.getChildren()[i])) return true;
		}
		
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return size(root);
	}
	
	/**
	 * Returns the number of elements in the given node.
	 * 
	 * @param node - node, of which the number of elements should be computed
	 * @return the number of elements in the given node
	 */
	private int size(TreeNode node) {
		int size = 0;
		
		for (Comparable key : node.getKeys()) {
			if (key != null) size++;
		}
		
		for (TreeNode child : node.getChildren()) {
			if (child != null) size += size(child);
		}
		
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int height() {
		int height = 1;
		TreeNode child = root;
		while ((child = child.getChildren()[0]) != null) height++; // all leaves are on the same level, therefore it is sufficient to check the height of any subtree
		return height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comparable getMax() {
		if (isEmpty()) return null;
		
		TreeNode child = root;
		while (! child.isLeaf()) {
			for (int i = child.getChildren().length - 1; i >= 0; i--) { // find node that contains the largest keys
				if (child.getChildren()[i] != null) {
					child = child.getChildren()[i];
					break;
				}
			}
		}

		Comparable max = null;
		for (int i = child.getKeys().length - 1; i >= 0; i--) {
			max = child.getKeys()[i];
			if (max != null) break;
		}
		
		return max;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comparable getMin() {
		if (isEmpty()) return null;
		
		TreeNode child = root;
		while (! child.isLeaf()) {
			child = child.getChildren()[0];
		}

		return child.getKeys()[0];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return root.getKeys()[0] == null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAll(BTree otherTree) {
		addAll(((MyBTree) otherTree).getRoot());
	}
	
	/**
	 * Inserts all elements in node into this tree.
	 * 
	 * @param node - the node, of which all elements should be inserted into this tree
	 */
	private void addAll(TreeNode node) {
		if (node == null) return;
		for (int i = 0; i < node.getKeys().length; i++) {
			if (node.getKeys()[i] != null) insert(node.getKeys()[i]);
			addAll(node.getChildren()[i]);
		}
		addAll(node.getChildren()[node.getChildren().length - 1]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	
	/**
	 * Prints all elements in node using InOrder-Traversal.
	 * 
	 * @param node - the node, of which all elements should be printed
	 */
	private void printInOrder(TreeNode node) {
		if (node == null) return;
		for (int i = 0; i < node.getKeys().length; i++) {
			printInOrder(node.getChildren()[i]);
			if (node.getKeys()[i] != null) System.out.print(node.getKeys()[i] + " ");
		}
		printInOrder(node.getChildren()[node.getChildren().length - 1]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	
	
	/**
	 * Prints all elements in node using PreOrder-Traversal.
	 * 
	 * @param node - the node, of which all elements should be printed
	 */
	private void printPreOrder(TreeNode node) {
		if (node == null) return;
		for (int i = 0; i < node.getKeys().length; i++) {
			if (node.getKeys()[i] != null) System.out.print(node.getKeys()[i] + " ");
			printPreOrder(node.getChildren()[i]);
		}
		printPreOrder(node.getChildren()[node.getChildren().length - 1]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	
	/**
	 * Prints all elements in node using PostOrder-Traversal.
	 * 
	 * @param node - the node, of which all elements should be printed
	 */
	private void printPostOrder(TreeNode node) {
		if (node == null) return;
		for (int i = 0; i < node.getKeys().length; i++) {
			printPostOrder(node.getChildren()[i]);
		}
		printPostOrder(node.getChildren()[node.getChildren().length - 1]);
		for (int i = 0; i < node.getKeys().length; i++) {
			if (node.getKeys()[i] != null) System.out.print(node.getKeys()[i] + " ");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printLevelOrder() {
		if (! isEmpty()) {
			Queue<Comparable> queue = new LinkedList<Comparable>();
			
			for (Comparable key : root.getKeys()) { // root keys
				if (key != null) queue.offer(key);
			}
			
			if (! root.isLeaf()) { // root has children
				addKeysLevelOrder(root.getChildren(), queue);
			}
			
			while (! queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
		}
	}
	
	/**
	 * Traverses the children in level order and appends their keys to the queue.
	 * 
	 * @param children - tree nodes, that are to be traversed
	 * @param queue - queue, to which the keys are added
	 */
	private void addKeysLevelOrder(TreeNode[] children, Queue<Comparable> queue) {
		for (TreeNode child : children) {
			if (child != null) {
				Comparable[] keys = child.getKeys();
				for (Comparable key : keys) {
					if (key != null) queue.add(key);
				}
			}
		}
		for (TreeNode child : children) {
			if (child != null && ! child.isLeaf()) {
				addKeysLevelOrder(child.getChildren(), queue);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BTree clone() {
		MyBTree newTree = new MyBTree(order);
		TreeNode newTreeRoot = new TreeNode(root);
		newTree.setRoot(newTreeRoot);
		return newTree;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}

}
