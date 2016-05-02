package com.marcelherd.uebung2.eis;

import java.util.ArrayList;
import java.util.List;

public class KoelnerEisdiele extends Eisdiele {
	
	private List<Eis> eisKarte;
	
	public KoelnerEisdiele() {
		eisKarte = new ArrayList<Eis>();
	}

	@Override
	public Eis erstellen(String typ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void begruessen(String typ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void kassieren(Eis eis) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verabschieden(Eis eis) {
		// TODO Auto-generated method stub

	}

	@Override
	public void entschuldigen(String typ) {
		// TODO Auto-generated method stub

	}

}
