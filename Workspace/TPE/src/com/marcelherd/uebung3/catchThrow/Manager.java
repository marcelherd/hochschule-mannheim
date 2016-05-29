package com.marcelherd.uebung3.catchThrow;

public class Manager {
	
	
	public void takeOrder(Customer c, Salad s, Service service, Cook cook){
		try {
			cook.cook(s, service, c);
		} catch (SaladIsFoulException e) {
			// Handle Exception...
			e.printStackTrace();
		}
	}
}
