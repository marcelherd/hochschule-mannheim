package com.marcelherd.uebung5;

import static gdi.MakeItSimple.*;

import com.marcelherd.uebung5.model.MyQueue;
import com.marcelherd.uebung5.model.Queue;

public class QueueApplication {
	
	private Queue queue;
	
	public QueueApplication() {
		queue = new MyQueue();
	}
	
	public static void main(String[] args) {
		QueueApplication application = new QueueApplication();
		
		while (true) {
			application.printMenu();
			application.printCurrentState();
			application.prompt();
		}
	}
	
	private void printMenu() {
		println("Available operations:");
		println("--------------------------");
		println("1\tenter(int val)");
		println("2\tleave()");
		println("3\tfront()");
		println("4\tisEmpty()");
		println("5\ttoString()");
		println("6\tempty()");
		println();
	}
	
	private void printCurrentState() {
		println("Current State:");
		println(queue);
		println();
	}
	
	private void prompt() {
		print("Choose an operation to run: ");
		int operation = readInt();
		
		try {
			switch (operation) {
			case 1: // enter(int val)
				print("Enter parameter (int val): ");
				int val = readInt();
				queue.enter(val);
				break;
			case 2: // leave()
				println("Output: " + queue.leave());
				break;
			case 3: // front()
				println("Output: " + queue.front());
				break;
			case 4: // isEmpty()
				println("Output: " + queue.isEmpty());
				break;
			case 5: // toString()
				println("Output: " + queue);
				break;
			case 6: // static empty()
				println("Output: " + MyQueue.empty());
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
