package com.marcelherd.uebung6;

import static gdi.MakeItSimple.*;

public class LinesOfCodeCounter {
	public static void main(String[] args) {

	}

	public static int countLines(String filename) {
		Object file = openInputFile(filename);
		int retval = 0;
		while (!isEndOfInputFile(file)) {

			String line = readLine(file);
			boolean empty = true;
			boolean commented = false;
			for (int i = 0; i < line.length() && empty && !commented; i++) {
				if (line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
					commented = true;
				} else if (line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
					boolean multipleLineComment = true;
					while (multipleLineComment) {
						line = readLine(file);
						for (int l = 0; l < line.length(); l++) {
							if (line.charAt(l) == '*' && line.charAt(l + 1) == '/' && multipleLineComment) {
								multipleLineComment = false;
							}
						}
					}

					commented = true;
				} else if (!(line.charAt(i) == ' ' || line.charAt(i) == '\t')) {
					empty = false;
				}
			}

			if (!(empty || commented)) {
				retval++;
			}

		}
		closeInputFile(file);
		return retval;
	}
}
