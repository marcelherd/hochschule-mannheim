package com.marcelherd.uebung2.encryption;

/**
 * Encrypts input by reversing it.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CrypterReverse implements Crypter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encrypt(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decrypt(String cypherText) {
		return new StringBuilder(cypherText).reverse().toString();
	}

}
