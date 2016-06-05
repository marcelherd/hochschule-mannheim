package com.marcelherd.uebung4.aufgabe1;

public class Starvation {
	
	protected Resource sharedResource = new Resource();
	protected volatile boolean active = true;

	public Starvation() {
		Foo[] threads = new Foo[1000];
		threads[0] = new Foo(this, "Thread 1", Thread.MAX_PRIORITY);
		for (int i = 1; i < threads.length - 1; i++) {
			threads[i] = new Foo(this, "Thread " + (i + 1), Thread.MAX_PRIORITY);
		}
		threads[threads.length - 1] = new Foo(this, "Thread 1000", Thread.MIN_PRIORITY);
		
		for (Thread thread : threads) thread.start();
		
		work(3000);
		
		active = false;
		
		work(500);
		
		System.out.println("----------------------------------------");
		System.out.println("MAX PRIORITY: " + threads[0]);
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

		private long counter = 0;

		public Foo(Starvation holder, String name, int priority) {
			super(name);
			this.holder = holder;
			setPriority(priority);
		}

		@Override
		public void run() {
			while (holder.active) {
				synchronized (holder.sharedResource) {
					step();
				}
			}
			System.out.println("Final state: " + this);
		}
		
		private void step() {
			counter++;
		}
		
		public String toString() {
			return "Current Thread: " + Thread.currentThread().getName() + ", counter: " + counter + ", prio: " + getPriority();
		}

	}
	
	public static void main(String[] args) {
		new Starvation();
		
		// Well, this doesn't exactly work. I guess its because Windows is interfering.
	}

}
