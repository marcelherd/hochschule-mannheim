package com.marcelherd.uebung2.auto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.uebung2.auto.Car;
import com.marcelherd.uebung2.auto.CarDealer;
import com.marcelherd.uebung2.auto.GasolineCar;
import com.marcelherd.uebung2.auto.HybridCar;
import com.marcelherd.uebung2.auto.util.Cars;

/**
 * Tests CarDealer functionality.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CarDealerTest {

	private CarDealer dealer;
	
	@Before
	public void setUp() { 
	     dealer = new CarDealer();
	}
	
	/**
	 * Test method for {@link com.marcelherd.uebung2.auto.CarDealer#offer(com.marcelherd.uebung2.auto.Car)}.
	 */
	@Test
	public void testOffer() {
		GasolineCar bmw = Cars.BMW;
		assertTrue(dealer.getCars().isEmpty());
		assertEquals(0, dealer.getCars().size());
		assertFalse(dealer.getCars().contains(bmw));
		dealer.offer(bmw);
		assertTrue(dealer.getCars().contains(bmw));
		assertEquals(1, dealer.getCars().size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.uebung2.auto.CarDealer#sell(com.marcelherd.uebung2.auto.Car)}.
	 */
	@Test
	public void testSell() {
		GasolineCar bmw = Cars.BMW;
		assertTrue(dealer.getCars().isEmpty());
		assertEquals(0, dealer.getCars().size());
		assertFalse(dealer.getCars().contains(bmw));
		dealer.offer(bmw);
		assertTrue(dealer.getCars().contains(bmw));
		assertEquals(1, dealer.getCars().size());
		dealer.sell(bmw);
		assertFalse(dealer.getCars().contains(bmw));
		assertEquals(0, dealer.getCars().size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.uebung2.auto.CarDealer#sell(com.marcelherd.uebung2.auto.Car)}.
	 */
	@Test
	public void testSellNonExistant() {
		GasolineCar bmw = Cars.BMW;
		assertFalse(dealer.getCars().contains(bmw));
		assertEquals(0, dealer.getCars().size());
		dealer.sell(bmw);
		assertFalse(dealer.getCars().contains(bmw));
		assertEquals(0, dealer.getCars().size());
	}
	
}
