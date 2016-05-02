package com.marcelherd.uebung2.eis;

import java.util.Arrays;

/**
 * Definiert ein Eisgericht
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public abstract class Eis {
	
	/**
	 * Bezeichnung des Eises z.B. Spaghettieis/Bananasplit/etc.
	 */
	private String name;
	
	/**
	 * Waffel/Becher/Teller/Schüssel/Glas/etc.
	 */
	private String behaeltnis;
	
	/**
	 * Bällchen/Bälle/Spaghettis/Klekse/etc. 
	 */
	private String art;
	
	/**
	 * Vanille/Schokolade/Straciatella/Zitrone/etc.
	 */
	private String[] sorten;
	
	/**
	 * Sahne/Schokosträusel/Keks/Soße/etc.
	 */
	private String[] extras;
	
	private double preis;
	
	public Eis() {
		
	}
	
	/**
	 * Bereitet das Eis vor - Behältnis nehmen..
	 */
	public abstract void vorbereiten();
	
	/**
	 * Füllt das Behältnis mit Sorten nach Art
	 */
	public abstract void fuellen();
	
	/**
	 * Dekoriert das Eis mit Extras
	 */
	public abstract void dekorieren();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBehaeltnis() {
		return behaeltnis;
	}

	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String[] getSorten() {
		return sorten;
	}

	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}

	public String[] getExtras() {
		return extras;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Eis [name=");
		builder.append(name);
		builder.append(", behaeltnis=");
		builder.append(behaeltnis);
		builder.append(", art=");
		builder.append(art);
		builder.append(", sorten=");
		builder.append(Arrays.toString(sorten));
		builder.append(", extras=");
		builder.append(Arrays.toString(extras));
		builder.append(", preis=");
		builder.append(preis);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eis other = (Eis) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
