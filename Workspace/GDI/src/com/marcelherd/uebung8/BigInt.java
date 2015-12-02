package uebung08;

public interface BigInt {

	/**
	 * Addiert eine andere Zahl vom Typ BigInt zu der vorliegenden Zahl.
	 */
	void add(BigInt number);

	/**
	 * Liefert die Anzahl der vorliegenden Ziffern der Zahl.
	 */
	int length();

	/**
	 * Liefert das Feld in dem die Ziffern gespeichert wurden.
	 */
	int[] getDigits();

	/**
	 * Liefert die vorliegende Zahl als String.
	 */
	String toString();
	
	/**
	 * Liefert genau dann true, wenn beide Zahlen gleich sind, sonst false.
	 */
	boolean equals( BigInt number );

}