package com.marcelherd.uebung1;

public class BTree implements IBTree {
	
	/*	Kriterien B-Baum:
	*	m = Ordnung
	*	m-2m Elemente / Node
	*	m+1-2m+1 Kinder / Node
	*	Wurzel = Leaf || mindestens 2 Kinder
	*/
	
	private TreeNode node;
	private IBTree[] subTrees;
	
	private int magnitude;
	
	public BTree(int magnitude) {
		this.magnitude = magnitude;
		node = new TreeNode(magnitude);
		subTrees = new IBTree[0];
	}

	@Override
	public boolean insert(Integer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Integer o) {
		if(node.contains(o)){
			return true;
		}
		for(int i = 0; i<subTrees.length; i++){
			if(subTrees[i].contains(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		int retval = 0;
		retval += node.size();
		for(int i = 0; i<subTrees.length; i++){
			retval += subTrees[i].size();
		}
		return retval;
	}

	@Override
	public int height() {
		if(subTrees.length==0){
			return 1;
		}
		return subTrees[0].height() + 1;
	}

	@Override
	public Integer getMax() {
		if(isEmpty()){
			return 0;
		}
		if(subTrees.length == 0){
			return node.getMax();
		}else{
			return subTrees[subTrees.length-1].getMax();
		}
	}

	@Override
	public Integer getMin() {
		if(isEmpty()){
			return 0;
		}
		if(subTrees.length == 0){
			return node.getMin();
		}else{
			return subTrees[0].getMin();
		}
	}

	@Override
	public boolean isEmpty() {
		if(subTrees.length == 0 && node.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void addAll(IBTree otherTree) {
		// TODO Auto-generated method stub
		
	}
/**
 * First prints the first half of subtrees (left) then node and at least the right half.
 */
	@Override
	public void printInOrder() {
		int toReach = subTrees.length / 2;
		for(int i = 0; i<subTrees.length; i++){
			if(i==toReach){
				System.out.println(node.toString());
			}
			subTrees[i].printInOrder();
		}
		if(subTrees.length == 0){
			System.out.println(node.toString());
		}
		
	}

	@Override
	public void printPreOrder() {
		System.out.println(node.toString());
		for(int i = 0; i<subTrees.length; i++){
			subTrees[i].printPreOrder();
		}
	}

	@Override
	public void printPostOrder() {
		for(int i = 0; i<subTrees.length; i++){
			subTrees[i].printPreOrder();
		}
		System.out.println(node.toString());
	}

	@Override
	public void printLevelOrder() {
		// TODO Auto-generated method stub
		
	}
	
	// TODO remove
	public void setSubTree(BTree b){
		IBTree[] tempTrees = subTrees;
		subTrees = new IBTree[subTrees.length+1];
		for(int i = 0; i<tempTrees.length; i++){
			subTrees[i] = tempTrees[i];
		}
		subTrees[subTrees.length-1] = b;
	}
	
	public void setNode(TreeNode t){
		this.node = t;
	}

}
