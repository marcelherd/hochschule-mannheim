package com.marcelherd.uebung2.encryption;

/**
 * Provides methods for decryption and encryption.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public interface Crypter {

	/**
	 * Returns the encrypted message.
	 * 
	 * @param message - message that should be encrypted
	 * @return the encrypted message
	 */
	public String encrypt(String message);
	
	/**
	 * Returns the decrypted message.
	 * 
	 * @param cypherText - text that is to be decyphered
	 * @return the decrypted message
	 */
	public String decrypt(String cypherText);
	
}
