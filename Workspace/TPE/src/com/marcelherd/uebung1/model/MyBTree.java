package com.marcelherd.uebung1.model;

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
				return false; // o is of a different type than the existing element(s), it can not be inserted
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Comparable o) {
		// TODO Auto-generated method stub
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
		// all leaves are on the same level, therefore it is sufficient to check the height of any subtree
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comparable getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comparable getMin() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printPreOrder() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printPostOrder() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printLevelOrder() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BTree clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
