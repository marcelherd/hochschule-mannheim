package ws15.uebung08;

import java.util.Arrays;

import org.junit.Test;

import com.marcelherd.uebung8.BigInt;
import com.marcelherd.uebung8.MyBigInt;

import static org.junit.Assert.*;

public class BigInt1stTest {

	@Test
	public void testAdd() {
		MyBigInt num1 = new MyBigInt("9000000000001");
		BigInt num2 = new MyBigInt(  "1000000000009");

		num1.add(num2);

		assertEquals("10000000000010", num1.toString());
		int[] expectedArray = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
		assertTrue(Arrays.toString(expectedArray) + " vs " + Arrays.toString(num1.getDigits()),
				Arrays.equals(expectedArray, num1.getDigits()));
		assertEquals(14, num1.length());
		assertTrue(num1.equals(new MyBigInt("10000000000010")));
		
		assertEquals(0, num1.compareTo(new MyBigInt("10000000000010")));
	}

}
