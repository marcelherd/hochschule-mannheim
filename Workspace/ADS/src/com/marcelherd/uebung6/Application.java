package com.marcelherd.uebung6;

import static gdi.MakeItSimple.*;

public class Application {

	private BinaryTree binaryTree;
	private BinaryTree otherBinaryTree;
	
	private BinaryTree active;
	
	public Application() {
		binaryTree = new MyBinaryTree();
		otherBinaryTree = new MyBinaryTree();
		active = binaryTree;
	}
	
	public static void main(String[] args) {
		Application application = new Application();
		
		while (true) {
			application.printMenu();
			application.prompt();
		}
	}
	
	private void printMenu() {
		println("Available operations:");
		println("--------------------------");
		println("1\tinsert(int val)");
		println("2\tinsert(String filename)");
		println("3\tcontains(int val)");
		println("4\tsize()");
		println("5\theight()");
		println("6\tgetMax()");
		println("7\tgetMin()");
		println("8\tremove(int val)");
		println("9\tisEmpty()");
		println("10\taddAll(BinaryTree otherTree)");
		println("11\tprintInorder()");
		println("12\tprintPostorder()");
		println("13\tprintPreorder()");
		println("14\tprintLevelorder()");
		println("15\tclone()\t// This sets the inactive working tree to be a deep clone of the active working tree");
		println("16\tChange working tree");
		println();
	}
	
	private void prompt() {
		print("Choose an operation to run: ");
		int operation = readInt();
		
		try {
			switch (operation) {
			case 1: // insert(int val)
				print("Enter parameter (int val): ");
				int val = readInt();
				println("Output: " + active.insert(val));
				break;
			case 2: // insert(String filename)
				print("Enter parameter (String filename): ");
				String filename = readLine();
				if (filename.equals("")) filename = readLine(); // if the stdin wasnt flushed properly..
				println("Output: " + active.insert(filename));
				break;
			case 3: // contains(int val)
				// TODO this throws an NPE, obviously buggy (add isEmpty() check)
				print("Enter parameter (int val): ");
				val = readInt();
				println("Output: " + active.contains(val));
			case 4: // size()
				println("Output: " + active.size());
				break;
			case 5: // height()
				// TODO implement
				break;
			case 6: // getMax()
				println("Output: " + active.getMax());
				break;
			case 7: // getMin()
				println("Output: " + active.getMin());
				break;
			case 8: // remove(int val)
				// TODO implement
				break;
			case 9: // isEmpty()
				println("Output: " + active.isEmpty());
				break;
			case 10: // addAll(BinaryTree otherTree)
				// TODO implement
				break;
			case 11: // printInorder()
				println("Output:");
				active.printInorder();
				break;
			case 12: // printPostorder()
				println("Output:");
				active.printPostorder();
				break;
			case 13: // printPreorder()
				println("Output:");
				active.printPreorder();
				break;
			case 14: // printLevelorder()
				println("Output");
				active.printLevelorder();
				break;
			case 15: // clone()
				if (active == binaryTree) {
					otherBinaryTree = binaryTree.clone();
				} else {
					binaryTree = otherBinaryTree.clone();
				}
				break;
			case 16: // Change working tree
				active = (active == binaryTree ? otherBinaryTree : binaryTree); // "toggle"
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
