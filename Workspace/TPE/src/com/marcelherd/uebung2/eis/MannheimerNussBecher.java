package com.marcelherd.uebung2.eis;

public class MannheimerNussBecher extends Eis {
	
	public MannheimerNussBecher() {
		setName("Nuss Becher");
		setBehaeltnis("Becher");
		setArt("Bällchen");
		setSorten(new String[] { "Nuss" });
		setExtras(new String[] { "Nusssoße", "Nussstückchen", "Sahne" });
		setPreis(5.5d);
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
