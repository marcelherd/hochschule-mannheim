package com.marcelherd.uebung3.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

import com.marcelherd.uebung3.io.encryption.Caesar;

/**
 * Reads and decrypt caesar-encrypted input.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CaesarReader extends FilterReader {

	private Caesar caesar;

	public CaesarReader(Reader in) {
		this(in, 3);
	}

	public CaesarReader(Reader in, int key) {
		super(in);
		caesar = new Caesar(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int read() throws IOException {
		char[] buf = new char[1];
		int result = read(buf, 0, 1);
		if (result == -1) {
			return -1;
		} else {
			return (int) buf[0];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int count = 0;
		
		while (count == 0) {
			count = in.read(cbuf, off, len);
			if (count == -1) return -1;
			
			int last = off;
			for (int i = off; i < off + count; i++) {
				cbuf[last++] = caesar.decrypt(cbuf[i]);
			}
			count = last - off;
		}
		return count;
	}

}
