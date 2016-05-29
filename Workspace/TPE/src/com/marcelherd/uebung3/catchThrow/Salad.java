package com.marcelherd.uebung3.catchThrow;

public class Salad {
 
	private boolean fouled;
	
	public Salad(boolean fouled){
		this.fouled = fouled;
	}
	public void cook(){
		//... cook it..anyhow.
	}
	
	public boolean isFouled(){
		return fouled;
	}
}
