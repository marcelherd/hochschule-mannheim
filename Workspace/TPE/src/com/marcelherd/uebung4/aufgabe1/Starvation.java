package com.marcelherd.uebung4.aufgabe1;

public class Starvation {
	
	protected Resource sharedResource = new Resource();
	protected volatile boolean active = true;

	public Starvation() {
		System.out.println("Creating 100.000 Threads. This will take a while.");
		
		Foo[] threads = new Foo[100000];
		for (int i = 0; i < threads.length - 1; i++) { // 99999 Threads haben maximale Priorität
			threads[i] = new Foo(this, "Thread " + (i + 1), Thread.MAX_PRIORITY);
		}
		threads[threads.length - 1] = new Foo(this, "Thread 1000", Thread.MIN_PRIORITY); // der letzte Thread hat minimale Priorität
		
		for (Thread thread : threads) thread.start();
		
		System.out.print("Working");
		for (int i = 0; i < 10; i++) {
			work(500);
			System.out.print(".");
		}
		
		System.out.println();
		
		active = false;

		int sum = 0; // Durchschnittscounter berechnen
		for (Foo thread : threads) {
			sum += thread.counter;
		}
		
		System.out.println("----------------------------------------------");
		System.out.println("AVERAGE: counter=" + (sum / threads.length));
		System.out.println("MIN PRIORITY: " + threads[threads.length - 1]);
	}
	
	/**
	 * Simulates work for 5000ms
	 */
	private void work(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Foo extends Thread {
		
		private Starvation holder;

		protected long counter = 0;

		public Foo(Starvation holder, String name, int priority) {
			super(name);
			this.holder = holder;
			setPriority(priority);
		}

		@Override
		public void run() {
			while (holder.active) { // solange das Programm läuft
				synchronized (holder.sharedResource) { // versuche die Resource zu locken
					step(); // tu etwas
				}
			}
		}
		
		private void step() {
			counter++;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Foo [counter=");
			builder.append(counter);
			builder.append(", getPriority()=");
			builder.append(getPriority());
			builder.append(", getName()=");
			builder.append(getName());
			builder.append("]");
			return builder.toString();
		}

	}
	
	public static void main(String[] args) {
		new Starvation();
	}

}
