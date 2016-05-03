package com.marcelherd.uebung2.encryption.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.uebung2.encryption.Crypter;
import com.marcelherd.uebung2.encryption.CrypterReverse;

/**
 * Tests CrypterReverse functionality.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CrypterReverseTest {
	
	private Crypter crypter;

	@Before
	public void setUp() throws Exception {
		crypter = new CrypterReverse();
	}

	/**
	 * Test method for {@link com.marcelherd.uebung2.encryption.CrypterReverse#encrypt(java.lang.String)}.
	 */
	@Test
	public final void testEncrypt() {
		String text = "caesar";
		String encrypted = crypter.encrypt(text);
		assertEquals(encrypted, "raseac");
	}

	/**
	 * Test method for {@link com.marcelherd.uebung2.encryption.CrypterReverse#decrypt(java.lang.String)}.
	 */
	@Test
	public final void testDecrypt() {
		String cypher = "raseac";
		String decrypted = crypter.decrypt(cypher);
		assertEquals(decrypted, "caesar");
	}

}
