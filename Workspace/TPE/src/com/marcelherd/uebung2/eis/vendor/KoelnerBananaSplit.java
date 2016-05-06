package com.marcelherd.uebung2.eis.vendor;

public class KoelnerBananaSplit extends Eis {
	
	KoelnerBananaSplit() {
		setName("Banana Split");
		setBehaeltnis("Schale");
		setArt("Bälle");
		setSorten(new String[] { "Banane", "Schokolade" });
		setExtras(new String[] { "Schokoladen-Kokos-Soße", "Bierteig-Waffeln", "1 halbierte Banane", "Sahne" });
		setPreis(6.5d);
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
