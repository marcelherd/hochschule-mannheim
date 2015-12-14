package com.marcelherd.uebung5;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

import com.marcelherd.uebung5.model.LinkedList;
import com.marcelherd.uebung5.model.MyLinkedList;

public class LinkedListApplication {

	private LinkedList first;
	private LinkedList second;
	private LinkedList third;

	private LinkedList active;

	public LinkedListApplication() {
		first = new MyLinkedList();
		second = new MyLinkedList();
		third = new MyLinkedList();

		active = first;
	}

	public static void main(String[] args) {
		LinkedListApplication application = new LinkedListApplication();

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
		println("12\tdelete(int index)");
		println("13\ttoString()");
		println("14\tadd(int index, int element)");
		println("15\tget(int index)");
		println("16\ttoArray()");
		println("17\tcloneDeep()");
		println("18\taddAll(LinkedList otherList)");
		println("19\tconcat(LinkedList otherList)");
		println("20\tempty()");
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
			case 4: // removeLast()
				println("Output: " + active.removeLast());
				break;
			case 5: // getFirst()
				println("Output: " + active.getFirst());
				break;
			case 6: // getLast()
				println("Output: " + active.getLast());
				break;
			case 7: // isEmpty()
				println("Output: " + active.isEmpty());
				break;
			case 8: // contains(int val)
				print("Enter parameter (int val): ");
				val = readInt();
				println("Output: " + active.contains(val));
				break;
			case 9: // clear()
				println("Output: " + active.clear());
				break;
			case 10: // size()
				println("Output: " + active.size());
				break;
			case 11: // clone()
				println("Output: " + active.clone());
				break;
			case 12: // delete(int index)
				print("Enter parameter (int index): ");
				int index = readInt();
				println("Output: " + active.delete(index));
				break;
			case 13: // toString()
				println("Output: " + active);
				break;
			case 14: // add(int index, int element)
				print("Enter parameter (int index): ");
				index = readInt();
				print("Enter parameter (int element): ");
				int element = readInt();
				println("Output: " + active.add(index, element));
				break;
			case 15: // get(int index)
				print("Enter parameter (int index): ");
				index = readInt();
				println("Output: " + active.get(index));
				break;
			case 16: // toArray()
				println("Output: " + Arrays.toString(active.toArray()));
				break;
			case 17: // cloneDeep()
				println("Output: " + active.cloneDeep());
				break;
			case 18: // addAll(LinkedList otherList)
				print("Enter list from which elements should be added (1-3): ");
				int choice = readInt();
				switch (choice) {
				case 1:
					println("Output: " + active.addAll(first));
					break;
				case 2:
					println("Output: " + active.addAll(second));
					break;
				case 3:
					println("Output: " + active.addAll(third));
					break;
				default:
					println("Error: Invalid list");
				}
				break;
			case 19: // concat(LinkedList otherList)
				print("Enter list to concatenate (1-3): ");
				choice = readInt();
				switch (choice) {
				case 1:
					active.concat(first);
					break;
				case 2:
					active.concat(second);
					break;
				case 3:
					active.concat(third);
					break;
				default:
					println("Error: Invalid list");
				}
				break;
			case 20: // empty()
				println("Output: " + MyLinkedList.empty());
				break;
			case 21: // Change working list
				print("Enter new working list (1-3): ");
				choice = readInt();
				switch (choice) {
				case 1:
					active = first;
					break;
				case 2:
					active = second;
					break;
				case 3:
					active = third;
					break;
				default:
					println("Error: Invalid list");
				}
			default:
				println("Error: Unknown operation.");
			}
		} catch (Exception e) {
			println(e.getMessage());
		}

		println("\n\n");
	}

}
