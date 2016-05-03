package com.marcelherd.uebung2.encryption.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.uebung2.encryption.Crypter;
import com.marcelherd.uebung2.encryption.CrypterCaesar;

/**
 * Tests CrypterCaesar functionality.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CrypterCaesarTest {
	
	private Crypter crypter;

	@Before
	public void setUp() throws Exception {
		crypter = new CrypterCaesar();
	}

	/**
	 * Test method for {@link com.marcelherd.uebung2.encryption.CrypterCaesar#encrypt(java.lang.String)}.
	 */
	@Test
	public final void testEncrypt() {
		String text = "caesar";
		String encrypted = crypter.encrypt(text);
		assertEquals(encrypted, "fdhvdu");
	}

	/**
	 * Test method for {@link com.marcelherd.uebung2.encryption.CrypterCaesar#decrypt(java.lang.String)}.
	 */
	@Test
	public final void testDecrypt() {
		String cypher = "fdhvdu";
		String decrypted = crypter.decrypt(cypher);
		assertEquals(decrypted, "caesar");
	}

}
