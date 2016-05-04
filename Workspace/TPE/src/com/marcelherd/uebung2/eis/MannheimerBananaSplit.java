package com.marcelherd.uebung2.eis;

public class MannheimerBananaSplit extends Eis {

	public MannheimerBananaSplit() {
		setName("Banana Split");
		setBehaeltnis("Becher");
		setArt("Bällchen");
		setSorten(new String[] { "Banane", "Vanille" });
		setExtras(new String[] { "Schokoladen-Soße", "Waffel", "1 halbierte Banane", "Sahne" });
		setPreis(5d);
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
