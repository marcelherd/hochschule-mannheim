package com.marcelherd.uebung3.io.encryption;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements caesar encryption.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Caesar {

	private int key;
	
	private Map<Character, Character> encryptionMap;
	private Map<Character, Character> decryptionMap;

	public Caesar(int key) {
		this.key = key;
		
		this.generateCharacterMaps();
	}

	/**
	 * Returns the encrypted message.
	 * 
	 * @param message - message that should be encrypted
	 * @return the encrypted message
	 */
	public String encrypt(String message) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (encryptionMap.containsKey(c)) {
				sb.append(encryptionMap.get(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public char encrypt(char c) {
		if (encryptionMap.containsKey(c)) return encryptionMap.get(c);
		return c;
	}

	/**
	 * Returns the decrypted message.
	 * 
	 * @param cypherText - text that is to be decyphered
	 * @return the decrypted message
	 */
	public String decrypt(String cipher) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cipher.length(); i++) {
			char c = cipher.charAt(i);
			if (decryptionMap.containsKey(c)) {
				sb.append(decryptionMap.get(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public char decrypt(char c) {
		if (decryptionMap.containsKey(c)) return decryptionMap.get(c);
		return c;
	}
	
	/**
	 * Generates caesar character mapping based on the key.
	 */
	private void generateCharacterMaps() {
		encryptionMap = new HashMap<Character, Character>();
		decryptionMap = new HashMap<Character, Character>();
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ";
		String encryptedAlphabet = shift(alphabet, key);
		
		for (int i = 0; i < alphabet.length(); i++) {
			encryptionMap.put(alphabet.charAt(i), encryptedAlphabet.charAt(i));
			decryptionMap.put(encryptedAlphabet.charAt(i), alphabet.charAt(i));
		}
	}
	
	/**
	 * Moves each character of input to the left (wraps around).
	 * 
	 * @param input - source string
	 * @return new (shifted) string
	 */
	private String shift(String input) {
		return input.substring(1, input.length()) + input.charAt(0);
	}

	/**
	 * Moves each character of input to the left (wraps around).
	 * 
	 * @param input - source string
	 * @param distance - how many times the input should be shifted
	 * @return new (shifted) string
	 */
	private String shift(String input, int distance) {
		for (int i = 0; i < distance; i++) {
			input = shift(input);
		}
		return input;
	}

}
