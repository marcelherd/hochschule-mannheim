package com.marcelherd.uebung2.encryption;

import com.marcelherd.uebung2.encryption.Crypter;
import com.marcelherd.uebung2.encryption.CrypterCaesar;
import com.marcelherd.uebung2.encryption.CrypterReverse;

/**
 * Application entry-point.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Application {
	
	public static void main(String[] args) {
		System.out.println("Caesar-Encryption");
		System.out.println("------------------");
		Crypter crypter = new CrypterCaesar(); // shifts cypher by 3
		String text = "caesar.";
		System.out.println("Text: '" + text + "'");
		String encrypted = crypter.encrypt(text);
		System.out.println("Encrypted: '" + encrypted + "'");
		String decrypted = crypter.decrypt(encrypted);
		System.out.println("Decrypted: '" + decrypted + "'\n");

		System.out.println("Reverse-Encryption");
		System.out.println("------------------");
		Crypter reverser = new CrypterReverse();
		System.out.println("Text: '" + text + "'");
		encrypted = reverser.encrypt(text);
		System.out.println("Encrypted: '" + encrypted + "'");
		decrypted = reverser.decrypt(encrypted);
		System.out.println("Decrypted: '" + decrypted + "'\n");
		
		System.out.println("Geheimbotschaft");
		System.out.println("------------------");
		
		String message = "XHMSNYYXYJQQJS";
		crypter = new CrypterCaesar(5);
		System.out.println("Decrypted: " + reverser.decrypt(crypter.decrypt(reverser.decrypt(message))));
	}

}
