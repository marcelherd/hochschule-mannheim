package com.marcelherd.uebung2.eis;

/**
 * Eisdiele.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public abstract class Eisdiele {

	/**
	 * Bestellt ein Eis vom angegebenen Typ.
	 * 
	 * @param typ - Typ des Eises, das bestellt werden soll
	 */
	public void bestellen(String typ) {
		begruessen();
		Eis eis = erstellen(typ);
		if (eis != null) {
			eis.vorbereiten();
			eis.fuellen();
			eis.dekorieren();
			kassieren(eis.getPreis());
			verabschieden(eis.getName());
		} else {
			entschuldigen(typ);
		}
	}

	/**
	 * Erzeugt ein konkretes Eis vom angegebenen Typ.
	 * 
	 * @param typ - Typ des Eises, das bestellt werden soll
	 * @return ein konkretes Eis vom angegebenen Typ
	 */
	public abstract Eis erstellen(String typ);

	/**
	 * Begrüßt den Kunden.
	 */
	abstract void begruessen();

	/**
	 * Kassiert den angegebenen Preis vom Kunden.
	 * 
	 * @param preis - Geldbetrag, der kassiert wird
	 */
	abstract void kassieren(double preis);

	/**
	 * Verabschiedet den Kunden mit seinem Eis.
	 * 
	 * @param eisName - Name des Eises, das bestellt wurde
	 */
	abstract void verabschieden(String eisName);

	/**
	 * Entschuldigt sich beim Kunden, weil das bestellte Eis nicht verfügbar ist.
	 * 
	 * @param typ - Typ des Eises, das bestellt wurde
	 */
	abstract void entschuldigen(String typ);
	
	/**
	 * Gibt dem Kunden die Eiskarte der Eisdiele.
	 * 
	 * @return die Eiskarte der Eisdiele.
	 */
	public abstract String[] getEiskarte();

}
