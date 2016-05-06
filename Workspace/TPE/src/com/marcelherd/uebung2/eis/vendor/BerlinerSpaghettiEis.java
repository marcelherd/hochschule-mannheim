package com.marcelherd.uebung2.eis.vendor;

public class BerlinerSpaghettiEis extends Eis {
	
	BerlinerSpaghettiEis() {
		setName("Spaghetti Eis");
		setBehaeltnis("Schale");
		setArt("Spaghettis");
		setSorten(new String[] { "Vanille" });
		setExtras(new String[] { "Erdbeersoße", "Geraspelte weiße Schokolade", "Sahne" });
		setPreis(4d);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void vorbereiten() {
		System.out.println(getName() + " wird in der " + getBehaeltnis() + " vorbereitet.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void fuellen() {
		System.out.println(getName() + " wird mit " + getArt() + " der Sorten " + String.join(", ", getSorten()) + " befüllt.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void dekorieren() {
		System.out.println(getName() + " wird dekoriert mit " + String.join(", ", getExtras()));
	}

}
