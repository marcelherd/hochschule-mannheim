package com.marcelherd.uebung2.eis.vendor;

/**
 * Eine Eisdiele in Berlin.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class BerlinerEisdiele extends Eisdiele {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Eis erstellen(String typ) {
		switch (typ) {
			case "Spaghettieis":
				return new BerlinerSpaghettiEis();
			case "Karamelbecher":
				return new BerlinerKaramelBecher();
			case "Pfirsichschale":
				return new BerlinerPfirsichSchale();
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
		return new String[] { "Spaghettieis", "Karamelbecher", "Pfirsichschale" };
	}
	
	/**
	 * Gibt den text in Dialekt zurück.
	 * 
	 * @param text - text, der in Dialekt gesprochen werden soll
	 * @return den text in Dialekt
	 */
	private String dialekt(String text) {
		return "*gesprochen mit Berliner Dialekt*: " + text;
	}

}
