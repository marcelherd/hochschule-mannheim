package com.marcelherd.uebung3.catchThrow;

public class Cook {
	
	public void cook(Salad s, Service service, Customer c) throws SaladIsFoulException{
		service.order(s, c);
	}
}
