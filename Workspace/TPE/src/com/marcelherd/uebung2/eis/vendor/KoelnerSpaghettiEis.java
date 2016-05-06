package com.marcelherd.uebung2.eis.vendor;

public class KoelnerSpaghettiEis extends Eis {
	
	KoelnerSpaghettiEis() {
		setName("Spaghetti Eis");
		setBehaeltnis("Becher");
		setArt("Spaghettis");
		setSorten(new String[] { "Vanille" });
		setExtras(new String[] { "Erdbeersoße", "Geraspelte weiße Schokolade", "Sahne" });
		setPreis(4.5d);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	void vorbereiten() {
		System.out.println(getName() + " wird im " + getBehaeltnis() + " vorbereitet.");
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
