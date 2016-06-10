package com.marcelherd.uebung4.aufgabe1;

public class Livelock {
	
	public Livelock() {
		Hungriger ehemann = new Hungriger("John");
		Hungriger ehefrau = new Hungriger("Jane");
		
		Gabel gabel = new Gabel(ehemann); // Gabel wird von den beiden geteilt
		
		Thread ehemannThread = new Thread(new Runnable() {
			public void run() { ehemann.abendessen(gabel, ehefrau);	}
		});
		ehemannThread.start();
		
		Thread ehefrauThread = new Thread(new Runnable() {
			public void run() { ehefrau.abendessen(gabel, ehemann); }
		});
		ehefrauThread.start();
	}
	
	class Gabel {
		private Hungriger besitzer;
		
		protected Gabel(Hungriger besitzer) { this.besitzer = besitzer; }
		
		protected synchronized Hungriger getBesitzer() { return besitzer; }
		protected synchronized void setBesitzer(Hungriger besitzer) { this.besitzer = besitzer; }
		
		protected synchronized void benutzen() { System.out.println(besitzer.name + " hat gegessen"); }
	}
	
	class Hungriger {
		protected String name;
		protected boolean hungrig;
		
		protected Hungriger(String name) { this.name = name; hungrig = true; }
		
		protected void abendessen(Gabel gabel, Hungriger partner) {
			while (hungrig) {
				if (gabel.besitzer != this) {
					warten();
					continue;
				}
				
				if (partner.hungrig) {
					System.out.println(name + ": Du darfst zuerst essen :)");
					gabel.setBesitzer(partner);
					continue;
				}
				
				gabel.benutzen();
				System.out.println(name + ": Ich bin satt.");
				gabel.setBesitzer(partner);
			}
		}
		
		private void warten() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Livelock();
	}

}
