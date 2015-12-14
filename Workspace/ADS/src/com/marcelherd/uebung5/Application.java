package com.marcelherd.uebung5;

import static gdi.MakeItSimple.*;

import com.marcelherd.uebung5.model.LinkedList;
import com.marcelherd.uebung5.model.MyLinkedList;
import com.marcelherd.uebung5.model.MyQueue;
import com.marcelherd.uebung5.model.Queue;

public class Application {

	private LinkedList first;
	private LinkedList second;
	private LinkedList third;

	private LinkedList active;

	public Application() {
		first = new MyLinkedList();
		second = new MyLinkedList();
		third = new MyLinkedList();

		active = first;
	}

	public static void main(String[] args) {
		Application application = new Application();

		while (true) {
			application.printMenu();
			application.printCurrentState();
			application.prompt();
		}
	}

	private void printMenu() {
		println("Available operations:");
		println("--------------------------");
		println("1\taddFirst(int val)");
		println("2\taddLast(int val)");
		println("3\tremoveFirst()");
		println("4\tremoveLast()");
		println("5\tgetFirst()");
		println("6\tgetLast()");
		println("7\tisEmpty()");
		println("8\tcontains(int val)");
		println("9\tclear()");
		println("10\tsize()");
		println("11\tclone()");
		println("13\tdelete(int index)");
		println("14\ttoString()");
		println("15\tadd(int index, int element)");
		println("16\tget(int index)");
		println("17\ttoArray()");
		println("18\tcloneDeep()");
		println("19\taddAll(LinkedList otherList)");
		println("20\tconcat(LinkedList otherList)");
		println("21\tChange working list");
		println();
	}

	private void printCurrentState() {
		int activeList = (active == first ? 1 : (active == second ? 2 : 3));
		println("Currently operating on list " + activeList + ".\nCurrent state:");
		println(active);
		println();
	}

	private void prompt() {
		print("Choose an operation to run: ");
		int operation = readInt();
		
		try {
			switch (operation) {
			case 1: // addFirst(int val)
				print("Enter parameter (int val): ");
				int val = readInt();
				active.addFirst(val);
				break;
			case 2: // addLast(int val)
				print("Enter parameter (int val): ");
				val = readInt();
				active.addLast(val);
				break;
			case 3: // removeFirst()
				println("Output: " + active.removeFirst());
				break;
			case 13: // delete(int index)
				print("Enter parameter (int index): ");
				int index = readInt();
				println("Output: " + active.delete(index));
				break;
			case 16: // get(int index)
				print("Enter parameter (int index): ");
				index = readInt();
				println("Output: " + active.get(index));
				break;
			default:
				println("Error: Unknown operation.");
			}
		} catch (Exception e) {
			println(e.getMessage());
		} 

		println("\n\n");
	}

}
