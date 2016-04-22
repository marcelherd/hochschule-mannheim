package com.marcelherd.uebung1;

public class Application {
	
	public static void main(String[] args) {
		TreeNode test1 = new TreeNode(2);
		TreeNode test2 = new TreeNode(2);
		TreeNode test3 = new TreeNode(2);
		
		test1.insert(1);
		test1.insert(2);
		test1.insert(3);
		test1.insert(4);
		
		test2.insert(5);
		test2.insert(6);
		test2.insert(7);
		test2.insert(8);
		
		test3.insert(9);
		test3.insert(10);
		test3.insert(11);
		test3.insert(12);
		
		BTree l = new BTree(2);
		BTree a = new BTree(2);
		BTree b = new BTree(2);
		
		a.setNode(test2);
		b.setNode(test3);
		l.setNode(test1);
		l.setSubTree(a);
		l.setSubTree(b);
		l.printPreOrder();
	}
	
}
