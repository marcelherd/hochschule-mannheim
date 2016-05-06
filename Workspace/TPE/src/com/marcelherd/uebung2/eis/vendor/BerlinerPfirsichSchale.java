package com.marcelherd.uebung2.eis.vendor;

public class BerlinerPfirsichSchale extends Eis {
	
	BerlinerPfirsichSchale() {
		setName("Pfirsich Schale");
		setBehaeltnis("Schale");
		setArt("Bällchen");
		setSorten(new String[] { "Pfirsich", "Joghurt" });
		setExtras(new String[] { "Pfirsich Würfel", "Waffel", "Sahne" });
		setPreis(5.0d);
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
