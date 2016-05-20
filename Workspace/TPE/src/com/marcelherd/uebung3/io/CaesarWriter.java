package com.marcelherd.uebung3.io;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

import com.marcelherd.uebung3.io.encryption.Caesar;

/**
 * Writes caesar-encrypted input.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CaesarWriter extends FilterWriter {
	
	private Caesar caesar;

	public CaesarWriter(Writer out) {
		this(out, 3);
	}
	
	public CaesarWriter(Writer out, int key) {
		super(out);
		caesar = new Caesar(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(int c) throws IOException {
		super.write(caesar.encrypt((char) c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			write(cbuf[off + i]);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(String str) throws IOException {
		super.write(caesar.encrypt(str));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(char[] cbuf) throws IOException {
		for (int i = 0; i < cbuf.length; ++i) {
			write(cbuf[i]);
		}
	}

}
