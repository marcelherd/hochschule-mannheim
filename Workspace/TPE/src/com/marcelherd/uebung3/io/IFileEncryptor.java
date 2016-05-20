package com.marcelherd.uebung3.io;

import java.io.File;

public interface IFileEncryptor {
	
	public File encrypt(File sourceDir);
	public File decrypt(File sourceDir);

}
