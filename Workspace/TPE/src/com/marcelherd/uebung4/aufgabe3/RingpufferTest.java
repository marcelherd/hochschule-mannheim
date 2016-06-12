package com.marcelherd.uebung4.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RingpufferTest {
	
	private Ringpuffer ringpuffer;

	@Before
	public void setUp() throws Exception {
		ringpuffer = new Ringpuffer(10);
	}

	@Test
	public final void testGet() {
		ringpuffer.buffer[0] = 10;
		ringpuffer.head++;
		assertTrue(ringpuffer.get() == 10);
	}
	
	@Test
	public final void testPut() {
		ringpuffer.put(10);
		assertTrue(ringpuffer.buffer[0] == 10);
	}

}
