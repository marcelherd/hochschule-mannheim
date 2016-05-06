package com.marcelherd.uebung2.eis.vendor;

/**
 * Eine Eisdiele in Köln.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class KoelnerEisdiele extends Eisdiele {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Eis erstellen(String typ) {
		switch (typ) {
			case "Spaghettieis":
				return new KoelnerSpaghettiEis();
			case "Bananasplit":
				return new KoelnerBananaSplit();
			case "Erdbeertraum":
				return new KoelnerErdbeerTraum();
			default:
				return null;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	void begruessen() {
		System.out.println(dialekt("'Guten Tag! Welches Eis hätten Sie denn gerne?'"));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	void kassieren(double preis) {
		System.out.println(dialekt("'Gut, das macht dann " + preis + "€, bitte.'"));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	void verabschieden(String eisName) {
		System.out.println(dialekt("'Auf wiedersehen! Lassen Sie sich ihr " + eisName + " schmecken!'"));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	void entschuldigen(String typ) {
		System.out.println(dialekt("'Es tut mir leid, leider bieten wir " + typ + " nicht an.'"));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getEiskarte() {
		return new String[] { "Spaghettieis", "Bananasplit", "Erdbeertraum" };
	}
	
	/**
	 * Gibt den text in Dialekt zurück.
	 * 
	 * @param text - text, der in Dialekt gesprochen werden soll
	 * @return den text in Dialekt
	 */
	private String dialekt(String text) {
		return "*gesprochen mit Kölschem Dialekt*: " + text;
	}

}
