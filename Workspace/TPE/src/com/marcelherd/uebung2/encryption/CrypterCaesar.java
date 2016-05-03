package com.marcelherd.uebung2.encryption;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements Caesar encryption.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CrypterCaesar implements Crypter {
	
	private int key;

	private Map<Character, Character> encryptionMap;
	private Map<Character, Character> decryptionMap;
	
	public CrypterCaesar() {
		this(3);
	}
	
	/**
	 * 
	 * @param key - key for decryption and encryption
	 */
	public CrypterCaesar(int key) {
		this.key = key;
		this.generateCharacterMaps();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encrypt(String message) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) { // character is alphabetical
				sb.append(encryptionMap.get(c));
			} else { // character is a symbol, don't encrypt
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decrypt(String cypherText) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cypherText.length(); i++) {
			char c = cypherText.charAt(i);
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) { // character is alphabetical
				sb.append(decryptionMap.get(c));
			} else { // character is a symbol, don't decrypt
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Generates caesar character mapping based on the key.
	 * 65 = 'A' -  90 = 'Z'
	 * 97 = 'a' - 122 = 'z'
	 */
	private void generateCharacterMaps() {
		encryptionMap = new HashMap<Character, Character>();
		decryptionMap = new HashMap<Character, Character>();
		
		for (char c = 'A'; c <= 'Z'; c++) {
			if ((c + key) <= 'Z') {
				encryptionMap.put(c, (char) (c + key)); // caps
				decryptionMap.put((char) (c + key), c); // caps
				encryptionMap.put((char) (c + 32), (char) (c + key + 32)); // non-caps
				decryptionMap.put((char) (c + key + 32), (char) (c + 32)); // non-caps
			} else {
				encryptionMap.put(c, (char) ((c + key) - 26)); // caps
				decryptionMap.put((char) ((c + key) - 26), c); // caps
				encryptionMap.put((char) (c + 32), (char) ((c + key + 32) - 26)); // non-caps
				decryptionMap.put((char) ((c + key + 32) - 26), (char) (c + 32)); // non-caps
			}
		}
	}

}
