package com.marcelherd.uebung3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Application entry-point.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Application {

	public static void main(String[] args) throws IOException {
		// CaesarWriter and CaesarReader
		/*
		PrintWriter f = new PrintWriter(new CaesarWriter(new FileWriter("caesar.txt")));
		f.println("Hello World!");
		f.close(); 
		
		BufferedReader br = new BufferedReader(new FileReader("caesar.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		
		br = new BufferedReader(new CaesarReader(new FileReader("caesar.txt")));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		*/
		
		// Let user try CaesarFileEncryptor
		try {
			IFileEncryptor caesarFileEncryptor = new CaesarFileEncryptor();
			System.out.println("(D)ecrypt or (E)ncrypt?");
			Scanner scanner = new Scanner(System.in);
			boolean userStupid = false;
			int stupidCounter = 0;
			do {
				userStupid = false;
				String input = scanner.nextLine();
				if (input.toLowerCase().startsWith("d")) {
					System.out.println("Enter path to directory that is to be decrypted:");
					String path = scanner.nextLine();
					caesarFileEncryptor.decrypt(new File(path));
				} else if (input.toLowerCase().startsWith("e")) {
					System.out.println("Enter path to directory that is to be encrypted:");
					String path = scanner.nextLine();
					caesarFileEncryptor.encrypt(new File(path));
				} else { // invalid option
					stupidCounter++;
					if (stupidCounter == 10) {
						System.err.println("Go home, you're drunk!");
						System.exit(-1);
					}
					double rnd = Math.random();
					if (rnd < 0.2) {
						System.out.println("Nope.");
					} else if (rnd < 0.4) {
						System.out.println("You almost had it.");
					} else if (rnd < 0.6) {
						System.out.println("Please try again.");
					} else if (rnd < 0.8) {
						System.out.println("That doesn't seem right.");
					} else {
						System.out.println("Nice try.");
					}
					userStupid = true;
				}
			} while (userStupid);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Exiting.");
		}
	}
	
}
