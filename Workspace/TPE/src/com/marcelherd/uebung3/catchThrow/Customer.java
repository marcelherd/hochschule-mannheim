package com.marcelherd.uebung3.catchThrow;

public class Customer {
	
	public void serve( Salad s) throws SaladIsFoulException{
		if(s.isFouled())
			throw new SaladIsFoulException("Salad is Fouled!");
	}
}
