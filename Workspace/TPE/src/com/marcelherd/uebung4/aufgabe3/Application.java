package com.marcelherd.uebung4.aufgabe3;

import java.util.Random;

public class Application {
	
	private Ringpuffer ringpuffer;
	
	protected boolean active = true;
	
	public Application() {
		ringpuffer = new Ringpuffer(10);
		
		Timer timer = new Timer(10000); // 10 seconds runtime
		
		Producer p1 = new Producer("Producer 1", 1000); // produces every second
		Producer p2 = new Producer("Producer 2", 2000); // produces every 2 seconds
		Producer p3 = new Producer("Producer 3", 3000); // produces every 3 seconds
		
		Consumer c1 = new Consumer("Consumer 1", 1000); // consumes every second
		Consumer c2 = new Consumer("Consumer 2", 2000); // consumes every 2 seconds
		
		timer.start();
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
	}
	
	protected synchronized Ringpuffer getRingpuffer() { return ringpuffer; }
	
	/* ********************************************************************************* */
	
	class Timer extends Thread {
		
		private int timer;
		
		public Timer(int timer) {
			this.timer = timer;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(timer);
				active = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/* ********************************************************************************* */
	
	class Consumer extends Thread {
		
		private int speed;
		
		public Consumer(String name, int speed) {
			setName(name);
			this.speed = speed;
		}
		
		@Override
		public void run() {
			while (active) {
				System.out.println(getName() + " retrieved " + getRingpuffer().get());
				waitForIt();
			}
		}
		
		private void waitForIt() {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class Producer extends Thread {
		
		private int speed;
		
		public Producer(String name, int speed) {
			setName(name);
			this.speed = speed;
		}
		
		@Override
		public void run() {
			Random random = new Random();
			
			while (active) {
				ringpuffer.put(random.nextInt());
				waitForIt();
			}
		}
		
		private void waitForIt() {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/* ********************************************************************************* */
	
	public static void main(String[] args) {
		new Application();
	}

}
