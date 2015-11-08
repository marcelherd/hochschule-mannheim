package com.marcelherd.uebung6;

import static gdi.MakeItSimple.*;

public class StringExtensions {

	public static void main(String[] args) {
		println("aeiouäüöfjdsü903953h0ßfsaÄÜÜÖÜDÜPK\n" + toUpper("aeiouäüöfjdsü903953h0ßfsaÄÜÜÖÜDÜPK"));
		String[] s = split("", ';');
		for(String k : s){
			println(k);
		}
		println(scan("asdasdsa", "asdasdsa") + "");
	}

	public static String toUpper(String original) {
		String upperOriginal = "";
		for (int i = 0; i < original.length(); i++) {
			char currentCharacter = original.charAt(i);
			if (currentCharacter >= 'a' && currentCharacter <= 'z') {
				upperOriginal += (char) (currentCharacter - 'a' + 'A');
			} else if (currentCharacter == 'ä') {
				upperOriginal += 'Ä';
			} else if (currentCharacter == 'ö') {
				upperOriginal += 'Ö';
			} else if (currentCharacter == 'ü') {
				upperOriginal += 'Ü';
			} else {
				upperOriginal += currentCharacter;
			}
		}
		return upperOriginal;
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
