package com.marcelherd.uebung3.catchThrow;

public class Restaurant {
	Manager manager = new Manager();
	Cook cook = new Cook();
	Customer customer = new Customer();
	Service service = new Service();
	public static void main(String[] args) {
		Restaurant r = new Restaurant();
		r.takeOrder(new Salad(true));
	}

	public void takeOrder(Salad s){
		manager.takeOrder(customer, s, service, cook);
	}
	
}
