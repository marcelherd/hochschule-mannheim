package uebung08;

import gdi.MISException;

/**
 * This class represents numbers which are greater than zero. Every single digit
 * is stored in an Array of Integers named digits.
 * 
 * @author Marcel Herd
 * @author Manuel Schwalm
 * @author Firas Romdhane
 */
public class MyBigInt implements BigInt, Comparable<BigInt> {

	int[] digits;

	/**
	 * Initialize a new Instance of an MyBigInt object.
	 * 
	 * @param bigInteger
	 *            String which should be parsed into a MyBigInteger. Only String
	 *            which represents positive numbers are allowed!
	 * @throws MISException
	 *             is thrown if an invalid character is found.
	 */
	public MyBigInt(String bigInteger) throws MISException {
		if (bigInteger.length() > 0) {
			int startOfValidValues = bigInteger.length() - 1;
			boolean valid = false;
			for (int i = 0; i < bigInteger.length() && !valid; i++) {
				if (bigInteger.charAt(i) - '0' != 0) {
					valid = true;
					startOfValidValues = i;
				}
			}
			digits = new int[bigInteger.length() - startOfValidValues];
			for (int i = startOfValidValues; i < bigInteger.length(); i++) {
				int digit = (int) (bigInteger.charAt(i) - '0');
				if (digit < 0 || digit > 9) {
					throw new MISException("Error at parsing String to MyBigInt: The character at " + (i + 1) + " (\'"
							+ bigInteger.charAt(i) + "\')" + " is not a valid digit!");
				}
				digits[i - startOfValidValues] = digit;
			}
		} else {
			throw new MISException("MyBigInt must contain at least one digit!");
		}
	}

	/**
	 * This procedure adds an BigInt to an another.
	 * 
	 * @param number
	 *            The BigInt which should be added to the other BigInt.
	 */

	@Override
	public void add(BigInt number) {
		int[] longerArray;
		int[] smallerArray;
		int[] newDigits;
		if (length() >= number.length()) {
			longerArray = getDigits();
			smallerArray = number.getDigits();
		} else {
			longerArray = number.getDigits();
			smallerArray = getDigits();
		}
		newDigits = new int[longerArray.length + 1];
		int j = smallerArray.length - 1;
		int i = longerArray.length - 1;
		while (i >= 0 && j >= 0) {
			int toInsert = longerArray[i] + smallerArray[j] + newDigits[i + 1];
			if (toInsert >= 10) {
				newDigits[i]++;
				toInsert -= 10;
			}
			newDigits[i + 1] = toInsert;
			i--;
			j--;
		}
		if (i != 0) {
			while (i >= 0) {
				int toInsert = longerArray[i] + newDigits[i + 1];
				if (toInsert >= 10) {
					newDigits[i]++;
					toInsert -= 10;
				}
				newDigits[i + 1] = toInsert;
				i--;
			}
		}

		if (newDigits[0] == 0) {
			int[] abridgedArray = new int[newDigits.length - 1];
			for (i = 0; i < abridgedArray.length; i++) {
				abridgedArray[i] = newDigits[i + 1];
			}
			newDigits = abridgedArray;
		}

		digits = newDigits;
	}

	/**
	 * 
	 * @return A representation of BigInt as String.
	 */
	@Override
	public String toString() {
		String retval = "";
		for (int i = 0; i < digits.length; i++) {
			retval += digits[i];
		}
		return retval;
	}

	/**
	 * Compares two BigInt values.
	 * 
	 * @param o
	 *            The BigInt which sould be compared to this BigInt
	 * @return -1 if o is smaller than this BigInt, 0 if they are equal and 1 if
	 *         this BigInt is bigger.
	 */
	@Override
	public int compareTo(BigInt o) {
		if (equals(o)) {
			return 0;
		}

		if (o.length() > length()) {
			return 1;
		} else {
			for (int i = 0; i < o.length(); i++) {
				if (o.getDigits()[i] > getDigits()[i]) {
					return 1;
				} else if (o.getDigits()[i] < getDigits()[i]) {
					return -1;
				}
			}
		}
		return -1;

	}

	/**
	 * @return the length of the digits Array.
	 */
	@Override
	public int length() {
		return digits.length;
	}

	/**
	 * @return digits as Array.
	 */
	@Override
	public int[] getDigits() {
		return digits;
	}

	/**
	 * Compares the BigInt values for equality.
	 * 
	 * @return true if both BigInt values are equal, and false if not.
	 */
	@Override
	public boolean equals(BigInt number) {
		if (number.length() != length()) {
			return false;
		}
		for (int i = 0; i < number.length(); i++) {
			if (number.getDigits()[i] != getDigits()[i]) {
				return false;
			}
		}
		return true;
	}

}
