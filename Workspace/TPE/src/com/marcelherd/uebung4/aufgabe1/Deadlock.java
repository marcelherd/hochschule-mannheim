package com.marcelherd.uebung4.aufgabe1;

public class Deadlock {
	
	public Deadlock() {
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		
		Foo foo = new Foo(r1, r2);
		Bar bar = new Bar(r1, r2);
		
		foo.start(); // locks r1, works {bar locks r2 here}, tries to lock r2
		bar.start(); // locks r2, works, tries to lock r1 (which is locked by foo -> can't release r2 -> foo can't release r1)
	}
	
	class Foo extends Thread {
		
		private Resource r1;
		private Resource r2;
		
		public Foo(Resource r1, Resource r2) {
			this.r1 = r1;
			this.r2 = r2;
		}
		
		@Override
		public void run() {
			synchronized (r1) {
				System.out.println("Foo locked r1");
				work();
				synchronized (r2) {
					System.out.println("Foo locked r2");
				}
				System.out.println("Foo released r2");
			}
			System.out.println("Foo released r1");
		}
		
	}

	class Bar extends Thread {
		
		private Resource r1;
		private Resource r2;
		
		public Bar(Resource r1, Resource r2) {
			this.r1 = r1;
			this.r2 = r2;
		}
		
		@Override
		public void run() {
			synchronized (r2) {
				System.out.println("Bar locked r2");
				work();
				synchronized (r1) {
					System.out.println("Bar locked r1");
				}
				System.out.println("Bar released r1");
			}
			System.out.println("Bar released r2");
		}
		
	}
	
	/**
	 * Simulates work for 100ms
	 */
	public static void work() {
		try {
			Thread.sleep(100); // simulate work
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new Deadlock();
	}

}

