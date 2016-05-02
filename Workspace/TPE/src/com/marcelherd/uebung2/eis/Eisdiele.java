package com.marcelherd.uebung2.eis;

public abstract class Eisdiele {
	
	public void bestellen(String typ) {
		begruessen(typ);
		Eis eis = erstellen(typ);
		if (eis == null) {
			entschuldigen(typ);
		} else {
			kassieren(eis);
		}
		verabschieden(eis);
	}
	
	public abstract Eis erstellen(String typ);
	
	public abstract void begruessen(String typ);
	
	public abstract void kassieren(Eis eis);
		
	public abstract void verabschieden(Eis eis);
	
	public abstract void entschuldigen(String typ);

}
