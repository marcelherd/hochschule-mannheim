package com.marcelherd.uebung6;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class StringExtensions {

	public static void main(String[] args) {
		println("Calling toUpper(String original)");
		print("Please enter parameter 1: ");
		println("Output: " + toUpper(readLine()));
		
		println();
		
		println("Calling split(String original, char delimiter)");
		print("Please enter parameter 1: ");
		String original = readLine();
		print("Please enter parameter 2: ");
		char delimiter = readChar();
		println("Output: " + Arrays.toString(split(original, delimiter)));
		
		// readChar() hinterlässt \n im Buffer
		readLine();
		println();
		
		println("Calling scan(String original, String needle)");
		print("Please enter parameter 1: ");
		original = readLine();
		print("Please enter parameter 2: ");
		String needle = readLine();
		println("Output: " + scan(original, needle));
	}

	public static String toUpper(String original) {
		String retval = "";
		
		for (int i = 0; i < original.length(); i++) {
			char c = original.charAt(i);
			if (c >= 'a' && c <= 'z') {
				retval += (char) (c - 'a' + 'A');
			} else if (c == 'ä' || c== 'ü' || c== 'ö') {
				/* Die Minuskel der Umlaute sind genau 32 Stellen von ihren Majuskeln entfernt.
				 * (char) 32 entspricht ' '
				 */
				retval += (char) (c - ' ');
			} else {
				retval += c;
			}
		}
		
		return retval;
	}
	
	
	public static String[] split(String original, char delimiter){
		int numberOfParts = 1;
		for(int i = 0; i<original.length(); i++){
			if(original.charAt(i)==delimiter){
				numberOfParts++;
			}
		}
		String[] splittedStringArray = new String[numberOfParts];
		int currentPart = 0;
		splittedStringArray[0] = "";
		for(int i = 0; i<original.length(); i++){
			if(original.charAt(i)!=delimiter){
				splittedStringArray[currentPart]+=original.charAt(i);
			}else{
				currentPart++;
				splittedStringArray[currentPart] = "";
			}
		}
		return splittedStringArray;
	}
	
	public static int scan(String original, String needle){
		if(needle.length()>original.length()){
			throw new GDIException("Die eingegebene Zeichenkette ist länger als die zu durchsuchende Zeichenkette!");
		}
		if(needle.length()==0){
			throw new GDIException("Der zu suchende String darf nicht leer sein!");
		}
		if(original.length()==0){
			throw new GDIException("Der zu durchsuchende String darf nicht leer sein!");
		}
		int needleLength = needle.length();
		boolean needleFound = false;
		int needlePosition = -1;
		for(int i = 0; i<original.length()-needle.length()+1 && !needleFound; i++){
			String actualCheck = "";
			for(int j = i; j<needleLength+i && !needleFound; j++){
				actualCheck+=original.charAt(j);
			}
			if(actualCheck.equals(needle)){
				needleFound = true;
				needlePosition = i;
			}
		}
		return needlePosition;
		
		
	}
}
