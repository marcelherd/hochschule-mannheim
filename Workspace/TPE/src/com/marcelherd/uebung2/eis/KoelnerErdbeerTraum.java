package com.marcelherd.uebung2.eis;

public class KoelnerErdbeerTraum extends Eis {
	
	public KoelnerErdbeerTraum() {
		setName("Erdbeertraum");
		setBehaeltnis("Becher");
		setArt("Bälle");
		setSorten(new String[] { "Erdbeere" });
		setExtras(new String[] { "Erdbeersoße", "Erdbeerstücke", "Sahne" });
		setPreis(5.5d);
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
