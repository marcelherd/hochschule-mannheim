package com.marcelherd.uebung5.list;

/**
 * The class ListNode is a helper class for every kind of LinkedLists
 * 
 * @author Wolfgang Schramm
 */
public class ListNode {

	private int value;
	private ListNode next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
