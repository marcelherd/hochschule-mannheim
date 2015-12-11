package com.marcelherd.uebung5.model;

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
	 * TODO was soll das hier machen? lol
	 * Privater Konstruktor und instanzerzeugung hierrüber??
	 * @return
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
	public int removeFirst() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFirst() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLast() {
		ListNode currentNode = head;
		while (currentNode != null && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getValue();
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(int val) {
		ListNode currentNode = head;
		boolean finished = false;
		while (currentNode != null && finished) {
			if (currentNode.getValue() == val) {
				return true;
			} else if (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			} else {
				finished = true;
			}
		}
		return false;
	}

	@Override
	public LinkedList clear() {
		head = null;
		return this; // could cause memory leaks but we are not concerned (ᵔᴥᵔ)
	}

	@Override
	public int delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(int index, int element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub
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
