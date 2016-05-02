package com.marcelherd.uebung1.model;

/**
 * BTree tree node implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class TreeNode {

	private Comparable[] keys;
	
	private TreeNode[] children;
	
	private int order;
	
	public TreeNode(int order) {
		this.order = order;
		keys = new Comparable[2 * order]; // jeder knoten außer der wurzel muss zwischen m und 2m keys enthalten
		children = new TreeNode[2 * order + 1]; // jeder knoten außer der wurzel hat zwischen m+1 und 2m+1 kinder
		// jeder knoten ist entweder ein blatt ohne nachfolger oder hat i+1 nachfolger, falls i die anzahl der elemente ist
		// alle blätter liegen auf dem gleichen niveau
	}
	
	private TreeNode(TreeNode copy) {
		this.order = copy.getOrder();
		this.keys = copy.keys.clone();
		this.children = copy.children.clone();
	}
	
	/**
	 * Attempts to insert o in this TreeNode.
	 * Returns null if explosions were handled within the TreeNode, or
	 * the element that should be inserted in the parent node otherwise.
	 * 
	 * @param o - element that is being inserted
	 * @param returnNode
	 * @return null if explosions were handled within the TreeNode, or the element
	 * 		   that should be inserted in the parent node
	 */
	public Comparable insert(Comparable o, TreeNode returnNode) {
		if (! isLeaf()) { // can't insert o in this node
			for (int i = 0; i < keys.length; i++) { // find node where o should be inserted
				if (keys[i] == null ){
					o = children[i].insert(o, returnNode);
					break;
				}	

				if (keys[i].compareTo(o) == 0) { // current key is equal to o
					return null; // duplicate key, don't do anything else
				} else if (keys[i].compareTo(o) > 0) { // current key is greater than o
					o = children[i].insert(o, returnNode); // insert o in the subtree left of this key
					break;
				}
			}
		}
		
		// find where o should be inserted within node
		if (o != null) {
			int insertionIndex = 0;
			while (insertionIndex < keys.length && keys[insertionIndex] != null && keys[insertionIndex].compareTo(o) < 0) { // find insertion index
				if (keys[insertionIndex].compareTo(o) == 0) { // duplicate key, don't do anything else
					return null;
				} 
				// current key is smaller than o, move further along
				insertionIndex++;
			}
			
			Comparable tmpKey = null;
			TreeNode tmpNode = null;
			TreeNode newNode = new TreeNode(returnNode);

			// insert o and right-shift subsequent siblings
			while (insertionIndex < keys.length) { 
				tmpKey = keys[insertionIndex];
				tmpNode = children[insertionIndex + 1];
				keys[insertionIndex] = o;
				children[insertionIndex + 1] = (newNode == null || isLeaf()) ? null : newNode;
				o = tmpKey;
				newNode = tmpNode;
				insertionIndex++;
			}
			
			// handle explosion
			if (o != null) {
				tmpNode = new TreeNode(order);
				
				for (insertionIndex = 0; insertionIndex < order-1; insertionIndex++) {
					tmpNode.keys[insertionIndex] = keys[order + insertionIndex + 1];
					tmpNode.children[insertionIndex] = children[order + insertionIndex + 1];
					keys[order+insertionIndex + 1] = null;
					children[order+insertionIndex + 1] = null;
				}

				tmpNode.children[order-1] = children[2 * order];
				children[2 * order] = null;
				tmpNode.keys[order-1] = o;
				tmpNode.children[order] = (newNode == null || isLeaf()) ? null : newNode;
				
				o = keys[order]; // middle element
				keys[order] = null;
				children[order + 1] = null;
				
				returnNode.setKeys(tmpNode.keys.clone());
				returnNode.setChildren(tmpNode.children.clone());
			}
		}
		
		return o;
	}
	
	/**
	 * Returns true if this node is a leaf.
	 * 
	 * @return true if this this node is a leaf
	 */
	public boolean isLeaf() {
		return children[0] == null; // no children = no subtrees
	}

	public Comparable[] getKeys() {
		return keys;
	}

	public void setKeys(Comparable[] keys) {
		this.keys = keys;
	}

	public TreeNode[] getChildren() {
		return children;
	}

	public void setChildren(TreeNode[] children) {
		this.children = children;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
}
