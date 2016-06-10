package com.marcelherd.uebung4.aufgabe1;

public class RaceCondition {
	
	public static void main(String[] args) {
		Resource sharedResource = new Resource(); // gemeinsame Resource, die einen int Wert enthält (value = 0)
		
		Foo t1 = new Foo(sharedResource);
		Foo t2 = new Foo(sharedResource);
		Foo t3 = new Foo(sharedResource);
		Foo t4 = new Foo(sharedResource);
		Foo t5 = new Foo(sharedResource);
		
		// 5 Threads inkrementieren den Wert der gemeinsamen Resource jeweils 1000 mal
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		// 1000 * 5 = 5000?
		System.out.println("Final value: " + sharedResource.value); // Oops!
		
		/*
		 * Inkrementation:
		 * value = value + 1;
		 * 
		 * 1. Hole den Wert von value
		 * 2. Addiere den Wert von value
		 * 3. Speichere das Ergebnis in value
		 * 
		 * Da alle Threads gleichzeitig diese Operationen ausführen, ist nicht gewährleistet,
		 * dass nicht ein anderer Thread zwischen diesen Operationen auch den Wert verändert.
		 */
	}

}

class Resource {
	
	public int value = 0;
	
}

class Foo extends Thread {
	
	private Resource resource;
	
	public Foo(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) { // 1000 Iterationen
			resource.value = resource.value + 1; // --> 1000 Inkrementationen
		}
	}
	
}
