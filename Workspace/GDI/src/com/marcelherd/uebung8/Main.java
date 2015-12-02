package uebung08;
import static gdi.MakeItSimple.*;

import java.math.BigInteger;
public class Main {
public static void main(String[] args) {
	print("Bitte geben Sie die zu prüfenden Zahlen (per leerzeichen getrennt) an: ");
	String allNumbers = readLine();
	String[] numbers = allNumbers.split(" ");
	for(String num : numbers){
		checkForErrors(num);
	}
}


	public static void checkForErrors(String number){
		boolean error = false;
		MyBigInt ownObject = new MyBigInt(number);
		BigInteger check = new BigInteger(number);
		number = check.toString();
		if(number.length()!=ownObject.length()){
			println(number.length() + "\n" + ownObject.length() + "\n");
			error = true;
		}
		if(!ownObject.toString().equals(number)){
			println(number + "\n" + ownObject.toString() + "\n");
			error = true;
		}
		if(ownObject.compareTo(ownObject) != check.compareTo(check)){
			println(check.compareTo(check) + "\n" + ownObject.compareTo(ownObject) + "\n" );
			error = true;
		}
		if(ownObject.equals(ownObject) != check.equals(check)){
			println(check.equals(check) + "\n" + ownObject.equals(ownObject) + "\n");
			error = true;
		}
		ownObject.add(ownObject);
		check = check.add(check);
		if(!check.toString().equals(ownObject.toString())){
			println(check.toString() + "\n" + ownObject.toString() + "\n");
			error = true;
		}
		if(!error){
			println("No errors at: " + number + "!");
		}
	}
}
