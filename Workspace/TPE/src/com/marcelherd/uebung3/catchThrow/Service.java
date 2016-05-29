package com.marcelherd.uebung3.catchThrow;

public class Service {

	public void order(Salad s, Customer c) throws SaladIsFoulException {
		c.serve(s);
	}

}
