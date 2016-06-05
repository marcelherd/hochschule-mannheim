package com.marcelherd.uebung3.sightseeing;

import static gdi.MakeItSimple.*;

import com.marcelherd.uebung3.sightseeing.exceptions.FatalFlightSimulatorException;
import com.marcelherd.uebung3.sightseeing.exceptions.GeneralFlightSimulatorException;
import com.marcelherd.uebung3.sightseeing.exceptions.PlaneTooHeighException;
import com.marcelherd.uebung3.sightseeing.exceptions.PlaneTooLowException;
import com.marcelherd.uebung3.sightseeing.exceptions.SimulatorConfigurationException;
/**
 * Flight Simulator Controll menue
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Simulator {
	private MyPlane plane = null;

	private int FatalFlightSimulatorExceptionCounter = 0;
	private int GeneralFlightSimulatorExceptionCounter = 0;
	private int PlaneTooLowExceptionCounter = 0;
	private int PlaneTooHeighExceptionCounter = 0;
	private int SimulatorConfigurationExceptionCounter = 0;
	
	public static void main(String[] args) {
		Simulator sim = new Simulator();
		sim.simulationStart();
	}

	/**
	 * Starts the simulation, resets the plane and is looping while the
	 * simulation.
	 */
	private void simulationStart() {
		setPlane();
		do {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printExceptionCounter();
			println("\n" + plane.toString());
			printMenue();

		} while (operate());
		printExceptionCounter();
	}


	/**
	 * prints the current count of each exception.
	 */
	private void printExceptionCounter() {
		System.out.println("FatalFlightSimulatorExceptions: " + FatalFlightSimulatorExceptionCounter);
		System.out.println("GeneralFlightSimulatorExceptions: " + GeneralFlightSimulatorExceptionCounter);
		System.out.println("PlaneTooLowExceptions: " + PlaneTooLowExceptionCounter);
		System.out.println("PlaneTooHeighExceptions: " + PlaneTooHeighExceptionCounter);
		System.out.println("SimulatorConfigurationExceptions: " + SimulatorConfigurationExceptionCounter);

	}
	/**
	 * creates a new {@link MyPlane}
	 */
	private void setPlane() {
		println("~Flight Simulator~");
		println("Route will be created...\n\n");
		print("Length of Route: ");
		int length = readInt();
		print("Minimum height over the city: ");
		int minHeight = readInt();
		print("Maximum height over the city: ");
		int maxHeight = readInt();
		try {
			plane = new MyPlane(new FlightRoute(length, minHeight, maxHeight));
		} catch (SimulatorConfigurationException e) {
			SimulatorConfigurationExceptionCounter++;
			e.printStackTrace();
		}
	}
	/**
	 * prints the menue for the user
	 */
	private void printMenue() {
		println("1) Close Doors");
		println("2) Fly next Kilometer");
		println("3) Stop");
		println("4) Open Doors");
	}
	/**
	 * Calls the methods of plane based on the choose in printMenue
	 * @return true when the operation should be stopped, so the simulation is over or had to be stopped.
	 */
	private boolean operate() {
		boolean retval = true;
		switch (readInt()) {
		case 1:
			plane.closeDoors();
			break;
		case 2:
			println("How many meters you want add to the height?");
			try {
				plane.flyNextKilometer(readInt());
			} catch (FatalFlightSimulatorException e) {
				FatalFlightSimulatorExceptionCounter++;
				e.printStackTrace();
				retval = false;
			} catch (PlaneTooHeighException e) {
				PlaneTooHeighExceptionCounter++;
				e.printStackTrace();
			} catch (PlaneTooLowException e) {
				PlaneTooLowExceptionCounter++;
				e.printStackTrace();
			} catch (GeneralFlightSimulatorException e) {
				GeneralFlightSimulatorExceptionCounter++;
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				plane.stop();
				retval = false;
			} catch (FatalFlightSimulatorException e) {
				FatalFlightSimulatorExceptionCounter++;
				e.printStackTrace();
				retval = false;
			} catch (GeneralFlightSimulatorException e) {
				GeneralFlightSimulatorExceptionCounter++;
				e.printStackTrace();
			}
			break;
			
		case 4:
			try {
				plane.openDoors();
			} catch (GeneralFlightSimulatorException e) {
				GeneralFlightSimulatorExceptionCounter++;
				e.printStackTrace();
			}
		default:
			println("Wrong input!");
		}
		return retval;
	}
}
