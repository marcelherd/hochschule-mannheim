package com.marcelherd.uebung1;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

import com.marcelherd.uebung1.model.MyBTree;
import com.marcelherd.uebung1.model.BTree;

/**
 * Application entry-point.
 * Provides a console interface to test B-Tree implementation.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Application {
	
	private BTree first;
	private BTree second;
	private BTree active;
	
	public Application(int order) {		
		first = new MyBTree(order);
		second = new MyBTree(order);
		active = first;
	}
	
	public static void main(String[] args) {
//		print("Please enter order: ");
//		int order = readInt();
//		
//		Application app = new Application(order);
//		
//		while (true) {
//			app.printMenu();
//			app.prompt();
//			app.printCurrentState();
//		}
		MyBTree tree = new MyBTree(1);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.delete(2);
	}
	
	private void printMenu() {
		println("Available operations:");
		println("--------------------------");
		println("1\tinsert(Integer o)");
		println("2\tinsert(String filename)");
		println("3\tcontains(Integer o)");
		println("4\tsize()");
		println("5\theight()");
		println("6\tgetMax()");
		println("7\tgetMin()");
		println("8\tisEmpty()");
		println("9\taddAll(BTree otherTree)");
		println("10\tprintInOrder()");
		println("11\tprintPreOrder()");
		println("12\tprintPostOrder()");
		println("13\tprintLevelOrder()");
		println("14\tclone()");
		println("15\tswitch working tree");
		println();
	}
	
	private void prompt() {
		print("Choose an operation to run: ");
		int operation = readInt();
		
		switch (operation) {
		case 1: // insert(Integer o)
			print("Enter parameter (Integer o): ");
			int o = readInt();
			println("Output: " + active.insert(o));
			break;
		case 2: // insert(String filename)
			print("Enter parameter (String filename): ");
			String filename = readLine();
			println("Output: " + active.insert(filename));
			break;
		case 3: // contains(Integer o)
			print("Enter parameter (Integer o): ");
			o = readInt();
			println("Output: " + active.contains(o));
			break;
		case 4: // size()
			println("Output: " + active.size());
			break;
		case 5: // height()
			println("Output: " + active.height());
			break;
		case 6: // getMax()
			println("Output: " + active.getMax());
			break;
		case 7: // getMin()
			println("Output: " + active.getMin());
			break;
		case 8: // isEmpty()
			println("Output: " + active.isEmpty());
			break;
		case 9: // addAll(BTree otherTree)
			active.addAll((active == first) ? second : first);
			break;
		case 10: // printInOrder()
			active.printInOrder();
			break;
		case 11: // printPreOrder()
			active.printPreOrder();
			break;
		case 12: // printPostOrder()
			active.printPostOrder();
			break;
		case 13: // printLevelOrder()
			active.printLevelOrder();
			break;
		case 14: // clone()
			if (active == first) {
				active = second = first.clone();
			} else {
				active = first = second.clone();
			}
			break;
		case 15: // switch
			active = (active == first) ? second : first;
			break;
		default:
			println("Error: Unknown operation.");
		}
	}
	
	private void printCurrentState() {
		int activeTree = (active == first ? 1 : 2);
		println("Currently operating on tree " + activeTree + ".\nCurrent state:");
		active.printInOrder();
		println();
	}
	
}
