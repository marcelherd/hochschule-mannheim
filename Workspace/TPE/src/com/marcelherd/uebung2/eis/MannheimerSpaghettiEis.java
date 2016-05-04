package com.marcelherd.uebung2.eis;

public class MannheimerSpaghettiEis extends Eis {
	
	public MannheimerSpaghettiEis() {
		setName("Spaghetti Eis");
		setBehaeltnis("Becher");
		setArt("Spaghettis");
		setSorten(new String[] { "Vanille" });
		setExtras(new String[] { "Monnemer Dreck" }); // ಠ_ಠ
		setPreis(3d);
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
