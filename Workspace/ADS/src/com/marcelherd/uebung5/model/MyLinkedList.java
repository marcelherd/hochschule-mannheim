package com.marcelherd.uebung5.model;

import java.util.NoSuchElementException;

public class MyLinkedList implements LinkedList {
	
	private ListNode head;
	
	public MyLinkedList() {
		head = null;
	}
	
	public MyLinkedList(int val) {
		head = new ListNode();
		head.setValue(val);
		head.setNext(null);
	}
	
	/**
	 * Returns an empty MyLinkedList
	 * 
	 * @return an empty MyLinkedList
	 */
	public static LinkedList empty() {
		return new MyLinkedList();
	}

	@Override
	public void addFirst(int val) {
		ListNode node = new ListNode();
		node.setValue(val);
		node.setNext(head);
		head = node;		
	}

	@Override
	public void addLast(int val) {
		ListNode node = new ListNode();
		node.setValue(val);
		node.setNext(null);
		
		// empty list
		if (head == null) {
			head = node;
		} else {
			// find last ListNode in LinkedList
			ListNode currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			// append new ListNode
			currentNode.setNext(node);
		}
	}

	@Override
	public int removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: List is empty");
		} else {
			int oldValue = head.getValue();
			head = head.getNext(); // null if size() == 1
			return oldValue;
		}
	}

	@Override
	public int removeLast() throws NoSuchElementException {
		if (isEmpty()) { // size == 0
			throw new NoSuchElementException("Error: List is empty");
		} else {
			if (size() > 1) {
				ListNode previousNode = head;
				ListNode currentNode = head.getNext();
				while (currentNode.getNext() != null) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				previousNode.setNext(null);
				return currentNode.getValue();
			}
			else { // size == 1
				int oldValue = head.getValue();
				head = null;
				return oldValue;
			}
		}
	}

	@Override
	public int getFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: List is empty");
		} else {
			return head.getValue();
		}
	}

	@Override
	public int getLast() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Error: List is empty");
		} else {
			ListNode currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getValue();
		}
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(int val) {
		if (isEmpty()) {
			return false;
		} else {
			ListNode currentNode = head;
			boolean finished = false;
			while (!finished) {
				if (currentNode.getValue() == val) {
					return true;
				} else if (currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
				} else {
					finished = true;
				}
			}
		}
		return false;
	}

	@Override
	public LinkedList clear() {
		head = null;
		return this; // possible memory leak?
	}
	
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			int size = 1;
			ListNode currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
				size++;
			}
			return size;
		}
	}
	
	@Override
	public LinkedList clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int index) throws IndexOutOfBoundsException {
		if (index >= size()) {
			throw new IndexOutOfBoundsException("Error: Invalid index");
		} else {
			if (size() == 1) {
				int oldValue = head.getValue();
				head = null;
				return oldValue;
			} else { // size > 1
				ListNode previousNode = head;
				ListNode currentNode = head;
				for (int i = 0; i < index; i++) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				previousNode.setNext(currentNode.getNext());
				return currentNode.getValue();
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		if (! isEmpty()) { // size > 0
			ListNode currentNode = head;
			if (size() == 1) {
				stringBuilder.append(head.getValue());
			} else { // size > 1
				while (currentNode.getNext() != null) {
					stringBuilder.append(currentNode.getValue() + ", ");
					currentNode = currentNode.getNext();
				}
				stringBuilder.append(currentNode.getValue());
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public boolean add(int index, int element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size()) {
			throw new IndexOutOfBoundsException("Error: Invalid index");
		} else {
			ListNode currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getValue();
		}
	}

	@Override
	public int[] toArray() {
		if (isEmpty()) {
			return new int[]{};
		} else {
			int[] retval = new int[size()];
			int currentIndex = 0;
			ListNode currentNode = head;
			retval[currentIndex] = currentNode.getValue();
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
				currentIndex++;
				retval[currentIndex] = currentNode.getValue();
			}
		}
		return null;
	}

	@Override
	public LinkedList cloneDeep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(LinkedList otherList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void concat(LinkedList otherList) {
		// TODO Auto-generated method stub
		
	}

}
