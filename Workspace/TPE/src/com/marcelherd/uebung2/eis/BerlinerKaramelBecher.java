package com.marcelherd.uebung2.eis;

public class BerlinerKaramelBecher extends Eis {
	
	public BerlinerKaramelBecher() {
		setName("Karamel Becher");
		setBehaeltnis("Becher");
		setArt("Bällchen");
		setSorten(new String[] { "Vanille", "Karamel" });
		setExtras(new String[] { "Karamelsoße", "Krokant Streußeln", "Sahne" });
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
