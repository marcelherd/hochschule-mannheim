package com.marcelherd.uebung3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CaesarFileEncryptor implements IFileEncryptor {

	@Override
	public File encrypt(File sourceDir) throws IllegalArgumentException {
		if (! sourceDir.exists()) throw new IllegalArgumentException("sourceDir does not exist!");
		if (! sourceDir.isDirectory()) throw new IllegalArgumentException("sourceDir must be a directory");

		// create target directory
		String encryptedFolderPath = sourceDir.getAbsolutePath().replace(sourceDir.getName(), sourceDir.getName() + "_encrypted");
		File encryptedFolder = new File(encryptedFolderPath);
		int copyId = 1;
		while (encryptedFolder.exists()) { // if directory exists, find a name
			encryptedFolder = new File(encryptedFolderPath + "(" + copyId + ")");
			copyId++;
		}
		encryptedFolder.mkdir();
		
		// traverse source directory
		encryptDirectory(sourceDir, encryptedFolder);

		return encryptedFolder;
	}
	
	private void encryptDirectory(File directory, File encryptedDirectory) {
		for (File file : directory.listFiles()) {
			if (! file.isDirectory()) {
				encryptFile(file, encryptedDirectory);
			} else {
				File newDirectory = new File(encryptedDirectory.getAbsolutePath() + "/" + file.getName());
				newDirectory.mkdir();
				encryptDirectory(file, newDirectory);
			}
		}
	}
	
	private void encryptFile(File file, File encryptedDirectory) {
		File newFile = new File(encryptedDirectory.getAbsolutePath() + "/" + file.getName());
		
		try (PrintWriter out = new PrintWriter(new CaesarWriter(new FileWriter(newFile)));
				BufferedReader in = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public File decrypt(File sourceDir) throws IllegalArgumentException {
		if (! sourceDir.exists()) throw new IllegalArgumentException("sourceDir does not exist!");
		if (! sourceDir.isDirectory()) throw new IllegalArgumentException("sourceDir must be a directory");
		
		// create target directory
		String decryptedFolderPath = sourceDir.getAbsolutePath().replace(sourceDir.getName(), sourceDir.getName() + "_decrypted");
		File decryptedFolder = new File(decryptedFolderPath);
		int copyId = 1;
		while (decryptedFolder.exists()) { // if directory exists, find a name
			decryptedFolder = new File(decryptedFolderPath + "(" + copyId + ")");
			copyId++;
		}
		decryptedFolder.mkdir();
		
		// traverse source directory
		decryptDirectory(sourceDir, decryptedFolder);

		return decryptedFolder;
	}
	
	private void decryptDirectory(File directory, File decryptedDirectory) {
		for (File file : directory.listFiles()) {
			if (! file.isDirectory()) {
				decryptFile(file, decryptedDirectory);
			} else {
				File newDirectory = new File(decryptedDirectory.getAbsolutePath() + "/" + file.getName());
				newDirectory.mkdir();
				decryptDirectory(file, newDirectory);
			}
		}
	}
	
	private void decryptFile(File file, File decryptedDirectory) {
		File newFile = new File(decryptedDirectory.getAbsolutePath() + "/" + file.getName());
		
		try (PrintWriter out = new PrintWriter(new FileWriter(newFile));
				BufferedReader in = new BufferedReader(new CaesarReader(new FileReader(file)))) {
			String line = null;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
