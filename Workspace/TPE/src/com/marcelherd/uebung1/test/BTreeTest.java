package com.marcelherd.uebung1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.uebung1.model.BTree;
import com.marcelherd.uebung1.model.MyBTree;

/**
 * Tests BTree functionality.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class BTreeTest {
	
	private BTree tree;
	
	@Before
	public void setUp() { 
	     tree = new MyBTree(1); 
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#insert(java.lang.Integer)}.
	 */
	@Test
	public void testInsertInteger() {
		for (int i = 1; i <= 10; i++) {
			assertFalse(tree.contains(i));
			tree.insert(i);
			assertTrue(tree.contains(i));
		}
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#insert(java.lang.String)}.
	 */
	@Test
	public void testInsertString() {
		URL path = BTreeTest.class.getResource("testdata.txt");
		tree.insert(path.getFile());
		
		for (int i = 1; i <= 10; i++) {
			assertTrue(tree.contains(i));
		}
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#contains(java.lang.Integer)}.
	 */
	@Test
	public void testContains() {
		assertFalse(tree.contains(5));
		tree.insert(5);
		assertTrue(tree.contains(5));
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#size()}.
	 */
	@Test
	public void testSize() {
		assertEquals(0, tree.size());
		tree.insert(5);
		assertEquals(1, tree.size());
		tree.insert(5);
		assertEquals(1, tree.size());
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#height()}.
	 */
	@Test
	public void testHeight() {
		assertEquals(1, tree.height());
		for (int i = 1; i <= 6; i++) {
			tree.insert(i);
		}
		assertEquals(2, tree.height());
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#getMax()}.
	 */
	@Test
	public void testGetMax() {
		assertEquals(null, tree.getMax());
		tree.insert(10);
		assertEquals(10, (int) tree.getMax());
		tree.insert(5);
		assertEquals(10, (int) tree.getMax());
		tree.insert(55);
		assertEquals(55, (int) tree.getMax());
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#getMin()}.
	 */
	@Test
	public void testGetMin() {
		assertEquals(null, tree.getMin());
		tree.insert(10);
		assertEquals(10, (int) tree.getMin());
		tree.insert(5);
		assertEquals(5, (int) tree.getMin());
		tree.insert(55);
		assertEquals(5, (int) tree.getMin());
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(tree.isEmpty());
		tree.insert(10);
		assertFalse(tree.isEmpty());
	}

	/**
	 * Test method for {@link com.marcelherd.uebung1.model.MyBTree#addAll(com.marcelherd.uebung1.model.BTree)}.
	 */
	@Test
	public void testAddAll() {
		BTree other = new MyBTree(4);
		for (int i = 1; i <= 10; i++) {
			other.insert(i);
		}
		tree.addAll(other);
		
		assertEquals(10, tree.size());
		for (int i = 1; i <= 10; i++) {
			assertTrue(tree.contains(i));
		}
	}

}
