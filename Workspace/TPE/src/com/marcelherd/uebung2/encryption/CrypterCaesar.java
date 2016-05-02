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
			sb.append(encryptionMap.get("" + message.charAt(i)));
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
			sb.append(decryptionMap.get("" + cypherText.charAt(i)));
		}
		return sb.toString();
	}
	
	/**
	 * Generates caesar character mapping based on the key
	 * 65 = 'A' -  90 = 'Z'
	 * 97 = 'a' - 122 = 'z'
	 */
	private void generateCharacterMaps() {
		encryptionMap = new HashMap<Character,Character>();
	}

}
