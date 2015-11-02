package com.marcelherd.uebung5.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.marcelherd.uebung5.SumUp;

public class SumUp1stTest {

	@Test
	public void beispiel() throws Exception {
		int[] numbers = {4, 5, 6};
		assertEquals(15, SumUp.sumUpNumbers(numbers));
	}

	@Test
	public void leerssArray() throws Exception {
		int[] numbers = {};
		assertEquals(0, SumUp.sumUpNumbers(numbers));
	}

}
