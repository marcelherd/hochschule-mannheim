package com.marcelherd.uebung3.sightseeing.test;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.uebung3.sightseeing.FlightRoute;
import com.marcelherd.uebung3.sightseeing.MyPlane;
import com.marcelherd.uebung3.sightseeing.exceptions.FatalFlightSimulatorException;
import com.marcelherd.uebung3.sightseeing.exceptions.GeneralFlightSimulatorException;
import com.marcelherd.uebung3.sightseeing.exceptions.PlaneTooHeighException;
import com.marcelherd.uebung3.sightseeing.exceptions.PlaneTooLowException;
import com.marcelherd.uebung3.sightseeing.exceptions.SimulatorConfigurationException;
/**
 * Tests MyPlane functionality.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class MyPlaneTest {

	private MyPlane plane;

	@Before
	public void setUp() {
		try {
			plane = new MyPlane(new FlightRoute(10, 100, 150));
		} catch (SimulatorConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = GeneralFlightSimulatorException.class)
	public void flyNextKilometerTest01() throws GeneralFlightSimulatorException {
		plane.flyNextKilometer(0);
	}

	@Test(expected = GeneralFlightSimulatorException.class)
	public void flyNextKilometerTest02() throws GeneralFlightSimulatorException {
		plane.closeDoors();
		plane.flyNextKilometer(10);
		plane.openDoors();
	}

	@Test(expected = FatalFlightSimulatorException.class)
	public void flyNextKilometerTest03() throws FatalFlightSimulatorException, GeneralFlightSimulatorException {
		plane.closeDoors();
		plane.flyNextKilometer(100);
		for (int i = 1; i <= 9; i++) {
			plane.flyNextKilometer(0);
		}
	}
	
	
	@Test
	public void flyNextKilometerTest04() throws FatalFlightSimulatorException, GeneralFlightSimulatorException {
		plane.closeDoors();
		plane.flyNextKilometer(100);
		for (int i = 1; i <= 8; i++) {
			plane.flyNextKilometer(0);
		}
		plane.flyNextKilometer(-100);
		plane.stop();
	}
	
	@Test(expected = PlaneTooLowException.class)
	public void flyNextKilometerTest05() throws PlaneTooLowException, GeneralFlightSimulatorException {
		plane.closeDoors();
		plane.flyNextKilometer(10);
		plane.flyNextKilometer(10);
		plane.flyNextKilometer(10);
	}
	
	@Test(expected = PlaneTooHeighException.class)
	public void flyNextKilometerTest06() throws PlaneTooHeighException, GeneralFlightSimulatorException {
		plane.closeDoors();
		plane.flyNextKilometer(100);
		plane.flyNextKilometer(100);
		plane.flyNextKilometer(100);
	}
	
	@Test
	public void flyNextKilometerTest07() throws GeneralFlightSimulatorException  {
		plane.closeDoors();
		plane.flyNextKilometer(100);
		plane.flyNextKilometer(100);
	}
	
	@Test
	public void flyNextKilometerTest08() throws GeneralFlightSimulatorException  {
		plane.closeDoors();
		plane.flyNextKilometer(100);
		for(int i = 1; i<8; i++){
			plane.flyNextKilometer(0);
		}
		plane.flyNextKilometer(100);
	}
	@Test(expected = GeneralFlightSimulatorException.class)
	public void flyNextKilometerTest09() throws GeneralFlightSimulatorException  {
		plane.closeDoors();
		
		plane.flyNextKilometer(1000);
	}
	@Test(expected = GeneralFlightSimulatorException.class)
	public void flyNextKilometerTest10() throws GeneralFlightSimulatorException  {
		plane.closeDoors();
		
		plane.flyNextKilometer(-1000);
	}
	
}
